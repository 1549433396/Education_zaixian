package com.jst.web.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jst.model.Questions;
import com.jst.model.QuestionsComment;
import com.jst.myservice.question.QuestionsCommentService;

@Controller
@RequestMapping("/admin/questionscomment")
public class QuestionsCommentController {
     
	 @Autowired
	 private QuestionsCommentService questionsCommentService;
	 
	 /*
	  * 查询
	  */
	 @RequestMapping("/list")
	 public ModelAndView ListQuestionsComment(@RequestParam(required=true,defaultValue="1")Integer page,HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		PageHelper.startPage(page,5);
		Map map=new HashMap<>();
		map=initMap(request, map);
		List<QuestionsComment> listQc=questionsCommentService.listAll(map);
		PageInfo<QuestionsComment> p = new PageInfo<QuestionsComment>(listQc);
		mv.addObject("page", p);
		mv.addObject("listQc", listQc);
		mv.setViewName("/manager/QuestionsCommentList");
		return mv;
	}
	 
	public Map initMap(HttpServletRequest request,Map map) {
		String qcid=request.getParameter("qcid");
		String qtitle=request.getParameter("qtitle");
		String isbest=request.getParameter("isbest");
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		/*System.out.println(isbest);
		System.out.println(qcid);*/
		if (qcid!=null&&qcid.trim().length()>0) {
			map.put("qcid",qcid);
		}
		if (isbest!=null&&!isbest.equals("-1")&&isbest.trim().length()>0) {
			map.put("isbest",isbest);
		}
		if (qtitle!=null&&qtitle.trim().length()>0) {
			map.put("qtitle", qtitle);
		}
		if (start!=null&&start.trim().length()>0) {
			map.put("start", start);
		}
		if (end!=null&&end.trim().length()>0) {
			map.put("end", end);
		}
		return map;
	}
	 
	 
	@RequestMapping("/getbyqid/{qid}")
	public ModelAndView getById(@RequestParam(required=true,defaultValue="1")Integer page,HttpServletRequest request,@PathVariable int qid) {
		ModelAndView mv=new ModelAndView();
		PageHelper.startPage(page,5);
		List<QuestionsComment> list=questionsCommentService. getqId(qid);
		PageInfo<QuestionsComment> p = new PageInfo<QuestionsComment>(list);
		mv.addObject("page", p);
		mv.addObject("list", list);
		mv.setViewName("/manager/CommentList");
		return mv;
	}
	
	 /*
	  * 查看回复删除
	  */
	 @RequestMapping("/del/{qcid}/{qid}")
	 public String deleteComment(@PathVariable int qcid,@PathVariable int qid) {
		 System.out.println(qcid+"==="+qid);
		 questionsCommentService.delete(qcid);
		return "redirect:/admin/questionscomment/getbyqid/"+qid;
	}
	/*
	  * 查看回复采纳最佳
	  */
	@RequestMapping("/updateIsBest/{qcid}/{qid}")
	public String updateIsBest(@PathVariable int qcid,@PathVariable int qid) {
		questionsCommentService.updateIsBest(qcid);
		return "redirect:/admin/questionscomment/getbyqid/"+qid;
	}
	
	/*
	  * 问答回复采纳最佳
	  */
	@RequestMapping("/updateIs_Best/{qcid}")
	public String updateIs_Best(@PathVariable int qcid) {
		questionsCommentService.updateIsBest(qcid);
		return "redirect:/admin/questionscomment/list";
	}
	 /*
	  * 删除
	  */
	 @RequestMapping("/delQc")
	 public String deleteQuestionsComment(int qcid) {
		questionsCommentService.delete(qcid);
		return "redirect:/admin/questionscomment/list";
	}
	 
	 /*
	  * 修改赋值
	  */
	 @RequestMapping("/getByid")
	 public ModelAndView getByid(int qcid) {
		 System.out.println(qcid);
	    ModelAndView mv=new ModelAndView();
		QuestionsComment questionsComment=questionsCommentService.getById(qcid);
		mv.addObject("questionsComment", questionsComment);
		return mv;
	}
}
