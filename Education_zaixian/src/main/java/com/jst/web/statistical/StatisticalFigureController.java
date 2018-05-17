package com.jst.web.statistical;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jst.model.Edu_User;
import com.jst.model.LoginLog;
import com.jst.myservice.statistical.StatisticalFigureService;
import com.jst.utils.JsonUtils;

@Controller
public class StatisticalFigureController {
	
	@Autowired
	private StatisticalFigureService sService;

	@RequestMapping("/admin/statisticsPage/registered")
	public ModelAndView shows(HttpServletRequest request) throws Exception {
		String create_time=request.getParameter("create_time");
		Map map=new HashMap<>();
		map.put("create_time", create_time);
		ModelAndView mView=new ModelAndView();
		List<Edu_User> listAll = sService.shows(map);
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
	
	@RequestMapping("/admin/statisticsPage/login")
	public ModelAndView statisticslogin(HttpServletRequest request) throws Exception {
		String login_time=request.getParameter("login_time");
		Map map=new HashMap<>();
		map.put("login_time", login_time);
		ModelAndView mView=new ModelAndView();
		List<LoginLog> listAll = sService.LoginShows(map);
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
		for (LoginLog loginLog : listAll) {
			list1.add(sdf2.format(sdf1.parse(loginLog.getLogin_time()+"")));
			list2.add(loginLog.getNum()+"");
		}
		mView.addObject("loginLog",JsonUtils.objectToJson(list1));
		mView.addObject("num", JsonUtils.objectToJson(list2));
		mView.setViewName("/manager/statisticalRegistered");
		return mView;
	}

}
