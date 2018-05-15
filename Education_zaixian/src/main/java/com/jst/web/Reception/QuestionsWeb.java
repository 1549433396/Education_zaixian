package com.jst.web.Reception;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.stat.TableStat.Mode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jst.mapper.question.QuestionsTagMapper;
import com.jst.model.Questions;
import com.jst.model.QuestionsTag;
import com.jst.myservice.question.QuestionsCommentService;
import com.jst.myservice.question.QuestionsService;
import com.jst.myservice.question.QuestionsTagService;
import com.jst.utils.JsonUtils;
import com.jst.utils.Result;

@Controller
@RequestMapping("/front/questions")
public class QuestionsWeb {

	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private QuestionsCommentService questionsCommentService;
	@Autowired
	private QuestionsTagMapper questionsTagMapper;
	@Autowired
	private QuestionsTagService questionsTagService;
	/*
	 * 查询
	 */
	@RequestMapping("/list/{id}")
	public ModelAndView ListQuestions(@PathVariable("id")int typeid) {
		ModelAndView mv=new ModelAndView();
		Map map = new HashMap<>();
		map.put("typeid", typeid);
		List<Questions> questionslist=questionsService.listAll(map);
		List<QuestionsTag> listTag=questionsTagMapper.listAll();
		mv.addObject("questionslist", questionslist);
		mv.addObject("listTag", listTag);
		mv.setViewName("/web/questions/questions-list");
		return mv;
	}
    
	@RequestMapping("/info/{id}")
    public ModelAndView infoquestion(@PathVariable("id")int qid) {
		System.out.println(qid);
		ModelAndView mv=new ModelAndView();
		Questions questions=questionsService.getById(qid);
		mv.addObject("questions", questions);
		mv.setViewName("/web/questions/questions-info");
		return mv;
	}
	
	/*
	 * 我要提问
	 */
	@RequestMapping("/ajax/add")
	public String addquestion(Questions questions) {
		questionsService.save(questions);
		return "/web/questions/questions-add";
	}
	/*
	 * 点赞
	 */
	@RequestMapping("/praise/ajax/add")
	@ResponseBody
	public Result updatePraise(int targetId,int type) {
		Result result=new Result();
		boolean b =false;
		if (type==1) {
			b=true;
			questionsService.updatePraise(targetId);
			result.setSuccess(b);
		}else if(type==2){
			questionsCommentService.updatepraise(targetId);
			b=true;
			result.setSuccess(b);
		}			
		return result;
	}
	
	//热门问答推荐
	@RequestMapping("/ajax/hotRecommend")
	@ResponseBody
	public Result hotRecommend() {
		Result result=new Result();
		boolean b =true;
		List<Questions> listquestions=questionsService.list();
		result.setEntity(listquestions);
		result.setSuccess(b);
//		System.out.println(result);
		return result;
	}
}
