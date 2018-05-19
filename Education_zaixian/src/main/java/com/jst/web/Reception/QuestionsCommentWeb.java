package com.jst.web.Reception;

import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jst.model.Edu_User;
import com.jst.model.Questions;
import com.jst.model.QuestionsComment;
import com.jst.myservice.question.QuestionsCommentService;
import com.jst.myservice.question.QuestionsService;
import com.jst.utils.Result;

@Controller
@RequestMapping("/front/questionscomment")
public class QuestionsCommentWeb {
     
	 @Autowired
	 private QuestionsCommentService questionsCommentService;
	 @Autowired
	 private QuestionsService questionsService;
		@RequestMapping("/ajax/list")
		public ModelAndView list(HttpServletRequest request){
			int qid=Integer.parseInt(request.getParameter("questionsComment.questionId"));
//			System.out.println(qid);
			ModelAndView mv=new ModelAndView();
			List<QuestionsComment> comments1 = questionsCommentService.getById2(qid);
			//最佳
			List<QuestionsComment> comments2 = questionsCommentService.getById3(qid);
			mv.addObject("comments1", comments1);
			mv.addObject("comments2", comments2);  
			mv.setViewName("/web/questionscomment/questionscomment-ajax-list");
			return mv;
		}
	 /*
	  * 添加评论
	  */
	 @RequestMapping("/ajax/add")
	 @ResponseBody
	 public Result addQuestionsComment(HttpServletRequest request,Questions questions,HttpSession session,QuestionsComment questionsComment) {
		Result result=new Result();
		int questionId=Integer.valueOf(request.getParameter("questionsComment.questionId"));
		String content=request.getParameter("questionsComment.content");
		Edu_User edu_User = (Edu_User) session.getAttribute("login_success");
		questions.setId(questionId);
		questionsComment.setQuestions(questions);
		questionsComment.setEduUser(edu_User);
		questionsComment.setContent(content);
		questionsComment.setIs_best(0);
		questionsComment.setReply_count(0);
		questionsComment.setPraise_count(0);
		questionsComment.setAdd_time(new Date());
		questionsComment.setComment_id(0);
		questionsCommentService.save(questionsComment);
//		System.out.println("=="+questionId);
		questionsService.updateReplyCount(questionId);
		boolean b=true;
		result.setSuccess(b);
//		return "redirect:/front/questionscomment/ajax/list";
		return result;
	}
	 /*
	  * 添加子评论
	  */
	 @RequestMapping("/ajax/addReply")
	 @ResponseBody
	 public Result addReply(HttpServletRequest request,Questions questions,HttpSession session,QuestionsComment questionsComment) {
		 Result result = new Result();
		 int contentId=Integer.valueOf(request.getParameter("questionsComment.commentId"));
		 String content=request.getParameter("questionsComment.content");
		 Edu_User edu_User = (Edu_User) session.getAttribute("login_success");
		    questions.setId(0);
			questionsComment.setQuestions(questions);
			questionsComment.setEduUser(edu_User);
			questionsComment.setComment_id(contentId);
			questionsComment.setContent(content);
			questionsComment.setIs_best(0);
			questionsComment.setReply_count(0);
			questionsComment.setPraise_count(0);
			questionsComment.setAdd_time(new Date());
			questionsCommentService.save(questionsComment);
//			System.out.println("=="+contentId);
	        questionsCommentService.updateReplyCount(contentId);
			boolean b=true;
			result.setSuccess(b);
//			System.out.println(result);
			return result;
//			return "redirect:/front/questionscomment/ajax/list";
	}
	 
		@RequestMapping("/ajax/getCommentById/{commentId}")
		@ResponseBody
		public ModelAndView getCommentById(@PathVariable("commentId")int commentId){
			ModelAndView mv = new ModelAndView();
			System.out.println(commentId+"=============");
			List<QuestionsComment>  comments= questionsCommentService.getListById(commentId);
			mv.addObject("comments", comments);
			mv.setViewName("web/questionscomment/questionscomment-ajax-listreply");
			return mv;
		}
		
		@RequestMapping("/ajax/acceptComment")
		@ResponseBody
		public ModelAndView getCommentById2(HttpServletRequest request){
			int commentId=Integer.valueOf(request.getParameter("questionsComment.commentId"));
			ModelAndView mv = new ModelAndView();
			System.out.println(commentId+"00000000000000");
			List<QuestionsComment>  questionsComments= questionsCommentService.getListById2(commentId);
			mv.addObject("questionsComments", questionsComments);
			System.out.println(mv);
			mv.setViewName("web/questionscomment/questionscomment-ajax-listreply_all");
			return mv;
		}
}
