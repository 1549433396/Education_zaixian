package com.jst.web.front;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jst.model.EduCourse;
import com.jst.model.Edu_User;
import com.jst.model.Edu_course_kpoint;
import com.jst.myservice.course.EduCourseService;
import com.jst.myservice.front.EduUserService;
import com.jst.utils.MD5Utils;
import com.jst.utils.Result;
import com.jst.utils.redis.JedisClientPool;

import redis.clients.jedis.JedisCluster;

@Controller
public class EduUserController {
	@Autowired
	private EduUserService eduUserService;
	
	@Autowired
	private JedisClientPool jedisClientPool;
	
	@Autowired
	private EduCourseService eduCourseService;
	private static final String getKopintHtml = "/web/course/videocode";// �γ̲���
	/**
	 * @param request
	 * @param response
	 * @param session
	 * �û���¼��֤
	 * @return
	 */
	@RequestMapping("/front/login")
	@ResponseBody
	public Result frontLogin(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) {
		//response.setHeader("Access-Control-Allow-Origin","*");
		String userName = request.getParameter("account");
		String pwd = request.getParameter("password");
		Result result = new Result();
		if (pwd == null && "".equals(pwd)) {
			result.setMessage("û�и��û�");
			result.setSuccess(false);
			return result;
		}
		pwd = MD5Utils.md5(pwd);
		String ipForget = request.getParameter("ipForget");
		Edu_User edu_User = eduUserService.getPwd(userName);
		System.out.println(edu_User+"tryuioo");
		if (edu_User.getPassword().equals(pwd)) {
			result.setMessage("��¼�ɹ���");
			String user_id = edu_User.getUser_id()+"";
			Set<String> set = jedisClientPool.hkeys(user_id);
			if (!set.isEmpty()) {
				for (String string : set) {
					Cookie cookie = new Cookie(string,jedisClientPool.hget(user_id,string));
					cookie.setMaxAge(30 * 60);// ����Ϊ30min  
		            cookie.setPath("/");  
		            response.addCookie(cookie); 
				}
			}
			
//            cookie.setMaxAge(30 * 60);// ����Ϊ30min  
//            cookie.setPath("/");  
//            response.addCookie(cookie); 
			result.setSuccess(true);
			session.setAttribute("login_success", edu_User);
			Edu_User user=(Edu_User)session.getAttribute("login_success");
			System.out.println("login:"+user);
			return result;
		}
		return result;
	}
	
	/**
	 * @param session
	 * ��ȡ�û���¼��Ϣ
	 * @param response
	 * @return
	 */
	@RequestMapping("/uc/getloginUser")
	@ResponseBody
	public Result getLoginUser(HttpSession session) {
		Edu_User edu_User = (Edu_User) session.getAttribute("login_success");
		if (edu_User == null) {
			return new Result(false, null, null);
		}else {
			return new Result(true, null, edu_User);
		}
	}
	
	
	/**
	 * �˳���¼
	 * @param session
	 * @return
	 */
	@RequestMapping("/uc/exit")
	@ResponseBody
	public Result exitUser(HttpSession session,HttpServletRequest request) {
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		int id = user.getUser_id();
		 Cookie[] cookies = request.getCookies();//��������Ի�ȡһ��cookie����  
         if (null==cookies) {  
             System.out.println("û��cookie=========");  
         } else {  
             for(Cookie cookie : cookies){
            	 jedisClientPool.hset(id+"", cookie.getName(), cookie.getValue());
                 System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue());  
             }  
         }  
		
		
		
		
		session.removeAttribute("login_success");
		return new Result();
	}
	
	@RequestMapping("/uc/createuser")
	@ResponseBody
	public Result createUser(HttpServletRequest request) {
		Edu_User user = new Edu_User();
		user.setEmail(request.getParameter("user.email"));
		user.setPassword(MD5Utils.md5(request.getParameter("user.password")));
		user.setMobile(request.getParameter("user.mobile"));
		eduUserService.addUser(user);
		return new Result(true, null, null);
	}
	
	
	/**
	 * ���벥��ҳ��
	 * 
	 * @param request
	 * @param courseId
	 *            �γ�ID
	 * @return ModelAndView
	 */
	@RequestMapping("/uc/play/{courseId}")
	public ModelAndView playVideo(HttpServletRequest request, @PathVariable("courseId") int courseId) {
		ModelAndView model = new ModelAndView();
		try {
			model.setViewName("/web/ucenter/player-video");
			// ��ȡ�γ�
			EduCourse course = eduCourseService.selectById(courseId);
			if (course != null) {
				model.addObject("course", course);
//				int userId = SingletonLoginUtils.getLoginUserId(request);
//				// ��ѯ�Ƿ��Ѿ��ղ�
//				boolean isFavorites = courseFavoritesService.checkFavorites(userId, courseId);
//				model.addObject("isFavorites", isFavorites);

				// ��ѯ�γ�Ŀ¼
				List<Edu_course_kpoint> parentKpointList = new ArrayList<Edu_course_kpoint>();
				List<Edu_course_kpoint> kpointList = eduCourseService.queryCourseKpointByCourseId(courseId);
				if (kpointList != null && kpointList.size() > 0) {
					// ���� һ��Ŀ¼
					for (Edu_course_kpoint temp : kpointList) {
						if (temp.getParent_id() == 0) {
							parentKpointList.add(temp);
						}
					}

					// ���� ��ȡ����Ŀ¼
					for (Edu_course_kpoint tempParent : parentKpointList) {
						for (Edu_course_kpoint temp : kpointList) {
							if (temp.getParent_id() == tempParent.getKpoint_id()) {
								tempParent.getList().add(temp);
							}
						}
					}
					model.addObject("parentKpointList", parentKpointList);
				}

//				 ��ؿγ�
//				List<CourseDto> courseList = courseService.queryInterfixCourseLis(course.getSubjectId(), 5,
//						course.getCourseId());
//				for (CourseDto tempCoursedto : courseList) {
//					List<Map<String, Object>> teacherList = teacherService
//							.queryCourseTeacerList(tempCoursedto.getCourseId());
//					tempCoursedto.setTeacherList(teacherList);
//				}
//				model.addObject("courseList", courseList);
//
//				CourseStudyhistory courseStudyhistory = new CourseStudyhistory();
//				courseStudyhistory.setUserId(Long.valueOf(userId));
//				courseStudyhistory.setCourseId(Long.valueOf(String.valueOf(courseId)));
//				// �ҵĿγ�ѧϰ��¼
//				List<CourseStudyhistory> couStudyhistorysLearned = courseStudyhistoryService
//						.getCourseStudyhistoryList(courseStudyhistory);
//				int courseHistorySize = 0;
//				if (couStudyhistorysLearned != null && couStudyhistorysLearned.size() > 0) {
//					courseHistorySize = couStudyhistorysLearned.size();
//				}
//				// ������Ƶ�ڵ�� ����
//				int sonKpointCount = courseKpointService.getSecondLevelKpointCount(Long.valueOf(courseId));
//				NumberFormat numberFormat = NumberFormat.getInstance();
//				// �ҵ�ѧϰ���Ȱٷֱ�
//				// ���þ�ȷ��С�����0λ
//				numberFormat.setMaximumFractionDigits(0);
//				String studyPercent = numberFormat.format((float) courseHistorySize / (float) sonKpointCount * 100);
//				if (sonKpointCount == 0) {
//					studyPercent = "0";
//				}
//				course.setStudyPercent(studyPercent);
				model.addObject("isok", true);
			}

		} catch (Exception e) {
//			model.setViewName(this.setExceptionRequest(request, e));
//			logger.error("playVideo()--error", e);
		}
		return model;
	}

	
	/**
	 * �����Ƶ���ŵ�html
	 * 
	 * @return
	 */
	@RequestMapping("/front/ajax/getKopintHtml")
	public String getKopintHtml(Model model, HttpServletRequest request, @RequestParam("kpointId") int kpointId,
			HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			Edu_course_kpoint courseKpoint = eduCourseService.queryCourseKpointById(kpointId);
			// ���������ݲ���ȷʱֱ�ӷ���
			if (courseKpoint == null) {
				out.println("<script>var noCover=true; dialog dialog('��ʾ','��������',1);</script>");
				return null;
			}

			// ��ȡ�γ�
			EduCourse course = eduCourseService.selectById(courseKpoint.getCourse_id());
			if (course == null) {
//				logger.info("++isok:" + false);
				return getKopintHtml;
			}
			model.addAttribute("courseKpoint", courseKpoint);
			model.addAttribute("course", course);
			model.addAttribute("kpointId", kpointId);
			/*
			 * //��Ƶ if("VIDEO".equals(courseKpoint.getFileType())){ // ��Ƶurl
			 * String videourl = courseKpoint.getVideoUrl(); // �������� String
			 * videotype = courseKpoint.getVideoType(); //��ѯinxeduVideo��key
			 * if(courseKpoint.getVideoType().equalsIgnoreCase(
			 * WebSiteProfileType.inxeduVideo.toString())){ Map<String,Object>
			 * map=(Map<String,Object>)websiteProfileService.
			 * getWebsiteProfileByType(WebSiteProfileType.inxeduVideo.toString()
			 * ).get(WebSiteProfileType.inxeduVideo.toString()); String play_url
			 * = "http://vod.baofengcloud.com/" + map.get("UserId") +
			 * "/player/cloud.swf"; String url =
			 * "servicetype=1&uid="+map.get("UserId")+"&fid="+videourl; play_url
			 * += "?" + url; //�������Ƶ�key��Ϊ���򰴼��ܲ������Ϊ���򲻼���
			 * if(StringUtils.isNotEmpty(map.get("SecretKey").toString())&&
			 * StringUtils.isNotEmpty(map.get("AccessKey").toString())){ String
			 * token =
			 * InxeduVideo.createPlayToken(videourl,map.get("SecretKey").
			 * toString(),map.get("AccessKey").toString()); play_url += "&tk=" +
			 * token; } play_url += "&auto=" + 1; videourl=play_url; }
			 * //��ѯcc��appId key if(courseKpoint.getVideoType().equalsIgnoreCase(
			 * WebSiteProfileType.cc.toString())){//���cc Map<String,Object>
			 * map=websiteProfileService.getWebsiteProfileByType(
			 * WebSiteProfileType.cc.toString());
			 * model.addAttribute("ccwebsitemap", map); } }
			 */
			// ��������
			model.addAttribute("videourl", courseKpoint.getVideo_url());
			model.addAttribute("videotype", courseKpoint.getVideo_type());
			return getKopintHtml;
			/*
			 * //�ı� if("TXT".equals(courseKpoint.getFileType())){ return
			 * playTxtAjax; }
			 */

			/*
			 * //�ж��Ƿ�Ϊ�ֻ������ boolean isMoblie = JudgeIsMoblie(request);
			 * model.addAttribute("isMoblie", isMoblie);
			 * 
			 * return getKopintHtml;
			 */
		} catch (Exception e) {
//			logger.error("CourseKpointController.getKopintHtml", e);
			return null;
		}
	}

}
