package com.jst.web.question;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jst.model.QuestionsTag;
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
		mv.setViewName("/manager/QuestionsTag");
		return mv;
	}
	
	
	@RequestMapping("/delQuestionsTag")
	@ResponseBody
	public String delQuestionsTag(int qtid) {
//		System.out.println(qtid);
		questionsTagService.delete(qtid);
		return "redirect:/admin/questions/toQuestionsTagList";
	}
	
	@RequestMapping("/save")
	public String insertTag(QuestionsTag questionsTag) {
		questionsTag.setCreate_time(new Date());
		questionsTagService.save(questionsTag);
//		System.out.println(questionsTag);
		return "redirect:/admin/questions/toQuestionsTagList";
	}
	
	@RequestMapping("/updateTag")
	@ResponseBody
	public String updateTag(@RequestParam(value = "id", defaultValue = "0") int qtid,@RequestParam(value = "name", defaultValue = "null")String tagName) {
		QuestionsTag questionsTag=new QuestionsTag();
		questionsTag.setQuestions_tag_id(qtid);
		questionsTag.setQuestions_tag_name(tagName);
		questionsTag.setCreate_time(new Date());
		System.out.println(questionsTag);
		questionsTagService.update(questionsTag);
		return "redirect:/admin/questions/toQuestionsTagList";
	}
}
	
	
	
	
