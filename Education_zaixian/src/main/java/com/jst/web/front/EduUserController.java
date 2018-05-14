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
	private static final String getKopintHtml = "/web/course/videocode";// 课程播放
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
		System.out.println(edu_User+"tryuioo");
		if (edu_User.getPassword().equals(pwd)) {
			result.setMessage("登录成功！");
			String user_id = edu_User.getUser_id()+"";
			Set<String> set = jedisClientPool.hkeys(user_id);
			if (!set.isEmpty()) {
				for (String string : set) {
					Cookie cookie = new Cookie(string,jedisClientPool.hget(user_id,string));
					cookie.setMaxAge(30 * 60);// 设置为30min  
		            cookie.setPath("/");  
		            response.addCookie(cookie); 
				}
			}
			
//            cookie.setMaxAge(30 * 60);// 设置为30min  
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
	 * 获取用户登录信息
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
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping("/uc/exit")
	@ResponseBody
	public Result exitUser(HttpSession session,HttpServletRequest request) {
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		int id = user.getUser_id();
		 Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组  
         if (null==cookies) {  
             System.out.println("没有cookie=========");  
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
	 * 进入播放页面
	 * 
	 * @param request
	 * @param courseId
	 *            课程ID
	 * @return ModelAndView
	 */
	@RequestMapping("/uc/play/{courseId}")
	public ModelAndView playVideo(HttpServletRequest request, @PathVariable("courseId") int courseId) {
		ModelAndView model = new ModelAndView();
		try {
			model.setViewName("/web/ucenter/player-video");
			// 获取课程
			EduCourse course = eduCourseService.selectById(courseId);
			if (course != null) {
				model.addObject("course", course);
//				int userId = SingletonLoginUtils.getLoginUserId(request);
//				// 查询是否已经收藏
//				boolean isFavorites = courseFavoritesService.checkFavorites(userId, courseId);
//				model.addObject("isFavorites", isFavorites);

				// 查询课程目录
				List<Edu_course_kpoint> parentKpointList = new ArrayList<Edu_course_kpoint>();
				List<Edu_course_kpoint> kpointList = eduCourseService.queryCourseKpointByCourseId(courseId);
				if (kpointList != null && kpointList.size() > 0) {
					// 遍历 一级目录
					for (Edu_course_kpoint temp : kpointList) {
						if (temp.getParent_id() == 0) {
							parentKpointList.add(temp);
						}
					}

					// 遍历 获取二级目录
					for (Edu_course_kpoint tempParent : parentKpointList) {
						for (Edu_course_kpoint temp : kpointList) {
							if (temp.getParent_id() == tempParent.getKpoint_id()) {
								tempParent.getList().add(temp);
							}
						}
					}
					model.addObject("parentKpointList", parentKpointList);
				}

//				 相关课程
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
//				// 我的课程学习记录
//				List<CourseStudyhistory> couStudyhistorysLearned = courseStudyhistoryService
//						.getCourseStudyhistoryList(courseStudyhistory);
//				int courseHistorySize = 0;
//				if (couStudyhistorysLearned != null && couStudyhistorysLearned.size() > 0) {
//					courseHistorySize = couStudyhistorysLearned.size();
//				}
//				// 二级视频节点的 总数
//				int sonKpointCount = courseKpointService.getSecondLevelKpointCount(Long.valueOf(courseId));
//				NumberFormat numberFormat = NumberFormat.getInstance();
//				// 我的学习进度百分比
//				// 设置精确到小数点后0位
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
	 * 获得视频播放的html
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
			// 当传入数据不正确时直接返回
			if (courseKpoint == null) {
				out.println("<script>var noCover=true; dialog dialog('提示','参数错误！',1);</script>");
				return null;
			}

			// 获取课程
			EduCourse course = eduCourseService.selectById(courseKpoint.getCourse_id());
			if (course == null) {
//				logger.info("++isok:" + false);
				return getKopintHtml;
			}
			model.addAttribute("courseKpoint", courseKpoint);
			model.addAttribute("course", course);
			model.addAttribute("kpointId", kpointId);
			/*
			 * //视频 if("VIDEO".equals(courseKpoint.getFileType())){ // 视频url
			 * String videourl = courseKpoint.getVideoUrl(); // 播放类型 String
			 * videotype = courseKpoint.getVideoType(); //查询inxeduVideo的key
			 * if(courseKpoint.getVideoType().equalsIgnoreCase(
			 * WebSiteProfileType.inxeduVideo.toString())){ Map<String,Object>
			 * map=(Map<String,Object>)websiteProfileService.
			 * getWebsiteProfileByType(WebSiteProfileType.inxeduVideo.toString()
			 * ).get(WebSiteProfileType.inxeduVideo.toString()); String play_url
			 * = "http://vod.baofengcloud.com/" + map.get("UserId") +
			 * "/player/cloud.swf"; String url =
			 * "servicetype=1&uid="+map.get("UserId")+"&fid="+videourl; play_url
			 * += "?" + url; //如果因酷云的key不为空则按加密播放如果为空则不加密
			 * if(StringUtils.isNotEmpty(map.get("SecretKey").toString())&&
			 * StringUtils.isNotEmpty(map.get("AccessKey").toString())){ String
			 * token =
			 * InxeduVideo.createPlayToken(videourl,map.get("SecretKey").
			 * toString(),map.get("AccessKey").toString()); play_url += "&tk=" +
			 * token; } play_url += "&auto=" + 1; videourl=play_url; }
			 * //查询cc的appId key if(courseKpoint.getVideoType().equalsIgnoreCase(
			 * WebSiteProfileType.cc.toString())){//如果cc Map<String,Object>
			 * map=websiteProfileService.getWebsiteProfileByType(
			 * WebSiteProfileType.cc.toString());
			 * model.addAttribute("ccwebsitemap", map); } }
			 */
			// 放入数据
			model.addAttribute("videourl", courseKpoint.getVideo_url());
			model.addAttribute("videotype", courseKpoint.getVideo_type());
			return getKopintHtml;
			/*
			 * //文本 if("TXT".equals(courseKpoint.getFileType())){ return
			 * playTxtAjax; }
			 */

			/*
			 * //判断是否为手机浏览器 boolean isMoblie = JudgeIsMoblie(request);
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
