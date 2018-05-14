package com.jst.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebFrontController {

	@RequestMapping("/front")
	public String index(){
		return "web/index/index";
	}
	
	@RequestMapping("/article")
	public String article(){
		return "web/article/article-list";
	}

	
	
	@RequestMapping("/front/teacher")
	public String teacher(){
		return "/web/teacher/teacher_list";
	}

	@RequestMapping("/front/question")
	public String question(){
		return "/web/questions/questions-list";
	}
}
