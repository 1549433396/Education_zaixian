package com.jst.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jst.model.Edu_Emailesend_History;
import com.jst.model.Edu_User;
import com.jst.model.Sys_user;
import com.jst.myservice.Edu_Emailesend_HistoryServiceImpl;
import com.jst.myservice.user.Edu_UserService;
import com.jst.realm.JavaEmailSender;
import com.jst.utils.MyJob;
import com.jst.utils.QuartzManager;

@Controller
public class Edu_Emailesend_HistoryController {
	  public static String JOB_NAME = "动态任务调度";  
	  public static String TRIGGER_NAME = "动态任务触发器";  
	  public static String JOB_GROUP_NAME = "XLXXCC_JOB_GROUP";  
	  public static String TRIGGER_GROUP_NAME = "XLXXCC_JOB_GROUP";
	@Autowired
	private Edu_Emailesend_HistoryServiceImpl eService;
	@Autowired
	private Edu_UserService uService;
	


	
	@RequestMapping("/admin/email/sendEmaillist")
	public ModelAndView list(HttpServletRequest request,@RequestParam(required=true,defaultValue="1")Integer page) {
		PageHelper.startPage(page,5);
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap();
		map = initMap(request, map);
		List<Edu_Emailesend_History> list = eService.list(map);
		PageInfo<Edu_Emailesend_History> p = new PageInfo<Edu_Emailesend_History>(list);
		mv.setViewName("/manager/edu_emailesend_historyList");
		mv.addObject("list",list);
		mv.addObject("page",p);
		return mv;
	}

	@RequestMapping("/admin/email/sendEmailinit/{id}")
	public ModelAndView init(@PathVariable("id")int id) {
		ModelAndView mv = new ModelAndView();
		Edu_Emailesend_History list = eService.getById(id);
		mv.setViewName("/manager/edu_emailesend_historyEdit");
		mv.addObject("list",list);
		return mv;
	}
	
	public Map initMap(HttpServletRequest request,Map map) {
		String email = request.getParameter("email");
		String type = request.getParameter("type");
		String status = request.getParameter("status");
		if (type!=null&&type.trim().length()!=0) {
			int type2 = Integer.parseInt(type);
			request.setAttribute("type",type2);
			map.put("type",type2);
		}
		if (email!=null) {
			request.setAttribute("email", email);
			map.put("email",email);
		}
		if (status!=null&&status.trim().length()!=0) {
			int status2 = Integer.parseInt(status);
			request.setAttribute("status",status2);
			map.put("status",status2);
		}
		return map;
	}
	/**
	 *  跳转到发送邮件界面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/admin/email/toEmailMsg")
	public ModelAndView add(HttpServletRequest request,@RequestParam(required=true,defaultValue="1")Integer page)throws Exception {
		ModelAndView mv = new ModelAndView();
		Map map=new HashMap();
		String parameter = request.getParameter("type");
		if (parameter!=null && parameter.trim().length()>0) {
			request.setAttribute("type", Integer.parseInt(parameter));
		}
		PageHelper.startPage(page,5);
		List<Edu_User> list = uService.listAll(map);
		PageInfo<Edu_User> p = new PageInfo<Edu_User>(list);
		mv.setViewName("/manager/edu_emailesend_historyAdd");
		mv.addObject("list",list);
		mv.addObject("page",p);
		return mv;
	}

	/**
	 * 发送邮件
	 * @throws Exception 
	 */
	@RequestMapping(value="/admin/email/sendEmail",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String sendEmail(Model model,HttpServletRequest request,Edu_Emailesend_History e) throws Exception {
		//获取后台登录值
		Sys_user users = (Sys_user)SecurityUtils.getSubject().getPrincipal();
		int type = Integer.parseInt(request.getParameter("type"));
		String toEmail = request.getParameter("email");
		String emailArray[] = toEmail.split(";");
		for (int i = 0; i < emailArray.length; i++) {
			e.setEmail(emailArray[i]);
			if (type==1) {
				JavaEmailSender.sendEmail(e);
			    e.setSend_time(new Date());
			    e.setUser(users);
			}else if (type==2) {
		      	String date=e.getStartTime();
				date = date.replace("T","");
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				e.setCreate_time(sf.parse(date));
				JobDetail job = JobBuilder.newJob(MyJob.class)
					    .withIdentity("myJob","group1")
					    .usingJobData("title",e.getTitle())
					    .usingJobData("content",e.getContent())
					    .usingJobData("email",e.getEmail())
					    .build();
				String[] dates=date.split(" ");
				String[] date_year=dates[0].split("-");
				String[] date_time=dates[1].split(":");//0 51 15 26 4 ? 2016
				String cons="0 "+date_time[1]+" "+date_time[0]+" "+date_year[2]+" "+date_year[1]+" ?"+" "+date_year[0];
				QuartzManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, job,cons);
			}
			e.setUser(users);
			e.setCreate_time(new Date());
			e.setSend_time(new Date());
			eService.save(e);
		}
		return "redirect:/admin/email/sendEmaillist";
	}

}
