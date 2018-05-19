package com.jst.web.Reception;

import java.util.Date;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.jst.model.Edu_User;
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
		List<QuestionsTag> listTag = questionsTagMapper.listAll();
		mv.addObject("listTag", listTag);
		mv.addObject("questions", questions);
		mv.setViewName("/web/questions/questions-info");
		return mv;
	}
 
	/*
	 * 点赞
	 */
//	@RequestMapping("/praise/ajax/add")
//	@ResponseBody
//	public Result updatePraise(HttpServletRequest request) {
//		int targetId=Integer.valueOf(request.getParameter("targetId"));
//		int type=Integer.valueOf(request.getParameter("type"));
//		Result result=new Result();
//		boolean b =false;
//		if (type==1) {
//			b=true;
//			questionsService.updatePraise(targetId);
//			result.setSuccess(b);
//		}else{
//			questionsCommentService.updatepraise(targetId);
//			b=true;
//			result.setSuccess(b);
//		}			
//		return result;
//	}
	
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
	/*
	 * 我要提问
	 */
	@RequestMapping("/ajax/add")
	public Result addQuestion(HttpServletRequest request,Questions questions,HttpSession session) {
		String title=request.getParameter("questions.title");
		String content=request.getParameter("questions.content");
		int type=Integer.valueOf(request.getParameter("questions.type"));
//		System.out.println(type);
		String a[]=request.getParameter("questionsTag").split(",");
//		System.out.println(a.length);
		int b[]=new int[a.length];
		for (int i = 1; i < a.length; i++) {
			b[i]=Integer.valueOf(a[i]);
		}
		Result result=new Result();
		boolean bol=true;
		result.setSuccess(bol);
		Edu_User edu_User = (Edu_User) session.getAttribute("login_success");
		questions.setEduUser(edu_User);
		questions.setTitle(title);
		questions.setType(type);
		questions.setContent(content);
		questions.setStatus(0);
		questions.setReply_count(0);
		questions.setBrowse_count(0);
		questions.setPraise_count(0);
		questions.setAdd_time(new Date());
		questionsService.save(questions);
		int qid =questionsService.getMaxId();
		for (int i = 1; i < b.length; i++) {
			Map map = new HashMap<>();
			int tid = b[i];
			map.put("qid", qid);
			map.put("tid", tid);
			questionsService.saveRelation(map);
		}
		return result;
	}

}
