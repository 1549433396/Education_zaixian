package com.jst.web.Reception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jst.mapper.question.QuestionsTagMapper;
import com.jst.model.QuestionsTag;
import com.jst.myservice.question.QuestionsTagService;

@Controller
@RequestMapping("/front/questions")
public class QuestionsTagWeb {
	@Autowired
	private QuestionsTagService questionsTagService;
	@Autowired
	private QuestionsTagMapper questionsTagMapper;
	@RequestMapping("/tag/{id}")
	public ModelAndView getByTag(@PathVariable int qtid) {
		System.out.println(qtid);
		ModelAndView mv=new ModelAndView();
		List<QuestionsTag> listTag=questionsTagService.getlistById(qtid);
		mv.addObject("listTag", listTag);
		return mv;
	}
	/*
	 * 标签查询
	 */
	@RequestMapping("/toadd")
	public ModelAndView listTag() {
		ModelAndView mv=new ModelAndView();
		List<QuestionsTag> listTag=questionsTagMapper.listAll();
		mv.addObject("listTag", listTag);
		mv.setViewName("/web/questions/questions-add");
		return mv;
	}
}
	
	
	
	
