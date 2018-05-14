package com.jst.web.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jst.model.LoginLog;
import com.jst.model.Questions;
import com.jst.myservice.user.LoginLogService;

@Controller
@RequestMapping("/addmin/LoginLog")
public class LoginLogController {
	
    @Autowired
	private LoginLogService loginLogService;
    
	@RequestMapping("/ListJournal")
	public ModelAndView ListJournal(@RequestParam int user_id,@RequestParam(required=true,defaultValue="1")Integer page) {
//		System.out.println(user_id);
		ModelAndView mv=new ModelAndView();
		PageHelper.startPage(page,5);
		List<LoginLog> listLogin=loginLogService.listAll(user_id);
		PageInfo<LoginLog> p = new PageInfo<LoginLog>(listLogin);
		mv.addObject("page", p);
//		System.out.println(listLogin);
		mv.addObject("listLogin", listLogin);
		mv.setViewName("EdUserJournal");
		return mv;
	}
}
