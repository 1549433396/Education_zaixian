package com.jst.web.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jst.myservice.question.QuestionsTagService;
import com.jst.utils.JsonUtils;
import com.jst.ztree.ZtreeNode;

@Controller
@RequestMapping("/admin/questions")
public class QuestionsTagController {
    
	@Autowired
	private QuestionsTagService questionsTagService;
	@RequestMapping("/toQuestionsTagList")
	public ModelAndView toQuestionsTag() {
		ModelAndView mv=new ModelAndView();
		List<ZtreeNode> list=questionsTagService.listAll();
		String json=JsonUtils.objectToJson(list);
		mv.addObject("json", json);
		mv.setViewName("QuestionsTag");
		return mv;
	}
}
	
	
	
	
