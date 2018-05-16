package com.jst.web.front;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
import com.jst.utils.JsonUtils;
import com.jst.utils.MD5Utils;
import com.jst.utils.Result;
import com.jst.utils.redis.JedisClientPool;

@Controller
public class EduUserController {
	@Autowired
	private EduUserService eduUserService;

	@Autowired
	private JedisClientPool jedisClientPool;

	@Autowired
	private EduCourseService eduCourseService;
	private static final String getKopintHtml = "/web/course/videocode";// 锟轿程诧拷锟斤拷
	/**
	 * @param request
	 * @param response
	 * @param session
	 * 用户登录验证
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
			result.setMessage("没有该用户");
			result.setSuccess(false);
			return result;
		}
		pwd = MD5Utils.md5(pwd);
		String ipForget = request.getParameter("ipForget");
		Edu_User edu_User = eduUserService.getPwd(userName);
		if (edu_User.getPassword().equals(pwd)) {
			result.setMessage("登录成功！");
			//			String user_id = edu_User.getUser_id()+"";
			//			Set<String> set = jedisClientPool.hkeys(user_id);
			Map map = new HashMap<>();
			//			if (!set.isEmpty()) {
			//				for (String string : set) {
			//					System.out.println(string+","+jedisClientPool.hget(user_id,string));
			//					map.put(string, jedisClientPool.hget(user_id,string));
			//					Cookie cookie = new Cookie(string,jedisClientPool.hget(user_id,string));
			//					cookie.setMaxAge(30 * 60);// 设置为30min 
			//				}
			//			}
			result.setSuccess(true);
			session.setAttribute("login_success", edu_User);
			//			result.setMap(map);
			//			System.out.println(map);
			return result;
		}
		return result;
	}

	/**
	 * @param session
	 * 锟斤拷取锟矫伙拷锟斤拷录锟斤拷息
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
	 * 锟剿筹拷锟斤拷录
	 * @param session
	 * @return
	 */
	@RequestMapping("/uc/exit")
	@ResponseBody
	public Result exitUser(HttpSession session,HttpServletRequest request) {
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		int id = user.getUser_id();
		Cookie[] cookies = request.getCookies();//锟斤拷锟斤拷锟斤拷锟斤拷曰锟饺∫伙拷锟絚ookie锟斤拷锟斤拷  
		if (null==cookies) {  
			System.out.println("没锟斤拷cookie=========");  
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
	 * 锟斤拷锟诫播锟斤拷页锟斤拷
	 * 
	 * @param request
	 * @param courseId
	 *            锟轿筹拷ID
	 * @return ModelAndView
	 */
	@RequestMapping("/uc/play/{courseId}")
	public ModelAndView playVideo(HttpServletRequest request, @PathVariable("courseId") int courseId) {
		ModelAndView model = new ModelAndView();
		try {
			model.setViewName("/web/ucenter/player-video");
			// 锟斤拷取锟轿筹拷
			EduCourse course = eduCourseService.selectById(courseId);
			if (course != null) {
				model.addObject("course", course);
				//				int userId = SingletonLoginUtils.getLoginUserId(request);
				//				// 锟斤拷询锟角凤拷锟窖撅拷锟秸诧拷
				//				boolean isFavorites = courseFavoritesService.checkFavorites(userId, courseId);
				//				model.addObject("isFavorites", isFavorites);

				// 锟斤拷询锟轿筹拷目录
				List<Edu_course_kpoint> parentKpointList = new ArrayList<Edu_course_kpoint>();
				List<Edu_course_kpoint> kpointList = eduCourseService.queryCourseKpointByCourseId(courseId);
				if (kpointList != null && kpointList.size() > 0) {
					// 锟斤拷锟斤拷 一锟斤拷目录
					for (Edu_course_kpoint temp : kpointList) {
						if (temp.getParent_id() == 0) {
							parentKpointList.add(temp);
						}
					}

					// 锟斤拷锟斤拷 锟斤拷取锟斤拷锟斤拷目录
					for (Edu_course_kpoint tempParent : parentKpointList) {
						for (Edu_course_kpoint temp : kpointList) {
							if (temp.getParent_id() == tempParent.getKpoint_id()) {
								tempParent.getList().add(temp);
							}
						}
					}
					model.addObject("parentKpointList", parentKpointList);
				}

				//				 锟斤拷乜纬锟�
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
				//				// 锟揭的课筹拷学习锟斤拷录
				//				List<CourseStudyhistory> couStudyhistorysLearned = courseStudyhistoryService
				//						.getCourseStudyhistoryList(courseStudyhistory);
				//				int courseHistorySize = 0;
				//				if (couStudyhistorysLearned != null && couStudyhistorysLearned.size() > 0) {
				//					courseHistorySize = couStudyhistorysLearned.size();
				//				}
				//				// 锟斤拷锟斤拷锟斤拷频锟节碉拷锟� 锟斤拷锟斤拷
				//				int sonKpointCount = courseKpointService.getSecondLevelKpointCount(Long.valueOf(courseId));
				//				NumberFormat numberFormat = NumberFormat.getInstance();
				//				// 锟揭碉拷学习锟斤拷锟饺百分憋拷
				//				// 锟斤拷锟矫撅拷确锟斤拷小锟斤拷锟斤拷锟�0位
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
	 * 锟斤拷锟斤拷锟狡碉拷锟斤拷诺锟絟tml
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
			// 锟斤拷锟斤拷锟斤拷锟斤拷锟捷诧拷锟斤拷确时直锟接凤拷锟斤拷
			if (courseKpoint == null) {
				out.println("<script>var noCover=true; dialog dialog('锟斤拷示','锟斤拷锟斤拷锟斤拷锟斤拷',1);</script>");
				return null;
			}

			// 锟斤拷取锟轿筹拷
			EduCourse course = eduCourseService.selectById(courseKpoint.getCourse_id());
			if (course == null) {
				//				logger.info("++isok:" + false);
				return getKopintHtml;
			}
			model.addAttribute("courseKpoint", courseKpoint);
			model.addAttribute("course", course);
			model.addAttribute("kpointId", kpointId);
			/*
			 * //锟斤拷频 if("VIDEO".equals(courseKpoint.getFileType())){ // 锟斤拷频url
			 * String videourl = courseKpoint.getVideoUrl(); // 锟斤拷锟斤拷锟斤拷锟斤拷 String
			 * videotype = courseKpoint.getVideoType(); //锟斤拷询inxeduVideo锟斤拷key
			 * if(courseKpoint.getVideoType().equalsIgnoreCase(
			 * WebSiteProfileType.inxeduVideo.toString())){ Map<String,Object>
			 * map=(Map<String,Object>)websiteProfileService.
			 * getWebsiteProfileByType(WebSiteProfileType.inxeduVideo.toString()
			 * ).get(WebSiteProfileType.inxeduVideo.toString()); String play_url
			 * = "http://vod.baofengcloud.com/" + map.get("UserId") +
			 * "/player/cloud.swf"; String url =
			 * "servicetype=1&uid="+map.get("UserId")+"&fid="+videourl; play_url
			 * += "?" + url; //锟斤拷锟斤拷锟斤拷锟狡碉拷key锟斤拷为锟斤拷锟津按硷拷锟杰诧拷锟斤拷锟斤拷锟轿拷锟斤拷虿患锟斤拷锟�
			 * if(StringUtils.isNotEmpty(map.get("SecretKey").toString())&&
			 * StringUtils.isNotEmpty(map.get("AccessKey").toString())){ String
			 * token =
			 * InxeduVideo.createPlayToken(videourl,map.get("SecretKey").
			 * toString(),map.get("AccessKey").toString()); play_url += "&tk=" +
			 * token; } play_url += "&auto=" + 1; videourl=play_url; }
			 * //锟斤拷询cc锟斤拷appId key if(courseKpoint.getVideoType().equalsIgnoreCase(
			 * WebSiteProfileType.cc.toString())){//锟斤拷锟絚c Map<String,Object>
			 * map=websiteProfileService.getWebsiteProfileByType(
			 * WebSiteProfileType.cc.toString());
			 * model.addAttribute("ccwebsitemap", map); } }
			 */
			// 锟斤拷锟斤拷锟斤拷锟斤拷
			model.addAttribute("videourl", courseKpoint.getVideo_url());
			model.addAttribute("videotype", courseKpoint.getVideo_type());
			return getKopintHtml;
			/*
			 * //锟侥憋拷 if("TXT".equals(courseKpoint.getFileType())){ return
			 * playTxtAjax; }
			 */

			/*
			 * //锟叫讹拷锟角凤拷为锟街伙拷锟斤拷锟斤拷锟� boolean isMoblie = JudgeIsMoblie(request);
			 * model.addAttribute("isMoblie", isMoblie);
			 * 
			 * return getKopintHtml;
			 */
		} catch (Exception e) {
			//			logger.error("CourseKpointController.getKopintHtml", e);
			return null;
		}
	}

	@RequestMapping("/admin/statisticsPage/registered")
	public ModelAndView initial() {
		ModelAndView mView=new ModelAndView();
		mView.setViewName("/manager/statisticalFigure");
		return mView;
	}

	@RequestMapping("/admin/statisticalFigure/shows")
	public ModelAndView shows(HttpServletRequest request) throws Exception {
		String create_time=request.getParameter("create_time");
		System.out.println(create_time+"create_time");
		Map map=new HashMap<>();
		map.put("create_time", create_time);
		ModelAndView mView=new ModelAndView();
		List<Edu_User> listAll = eduUserService.shows(map);
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
		for (Edu_User edu_User : listAll) {
			list1.add(sdf2.format(sdf1.parse(edu_User.getCreate_time()+"")));
			list2.add(edu_User.getNum()+"");
		}
		mView.addObject("create_time",JsonUtils.objectToJson(list1));
		mView.addObject("num", JsonUtils.objectToJson(list2));
		mView.setViewName("/manager/statisticalFigure");
		return mView;
	}
}
