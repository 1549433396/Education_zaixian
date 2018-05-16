package com.jst.web.articleFront;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jst.mapper.article.CommentMapper;
import com.jst.model.EduComment;
import com.jst.model.Edu_Article;
import com.jst.model.Edu_Comment;
import com.jst.model.Edu_User;
import com.jst.myservice.article.ArticleService;
import com.jst.myservice.article.CommentService;
import com.jst.utils.Result;

@Controller
public class ArticleFrontController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/article")
	public ModelAndView article(){
		ModelAndView mView=new ModelAndView();
		List<Edu_Article>list=articleService.alistAll();
		mView.addObject("articleList", list);
		mView.setViewName("web/article/article-list");
		return mView;
	}

	@RequestMapping("/front/articleinfo/{article_id}")
	public ModelAndView articleinfo(@PathVariable int article_id) {
		ModelAndView mView=new ModelAndView();
		Edu_Article edu_Article=articleService.getById(article_id);
		Edu_Article edu_Article2=new Edu_Article();
		articleService.click_numEdit(article_id);
		mView.addObject("article", edu_Article);
		mView.setViewName("/web/article/article-info");
		return mView;  
	}
	
	@RequestMapping("/web/comment/ajax/query")
	public ModelAndView comment(int otherId) {
		ModelAndView mView=new ModelAndView();
		List<Edu_Comment>edu_Comment=commentService.getByOther(otherId);
		mView.setViewName("/web/comment/comment");
		mView.addObject("commentList", edu_Comment);
		return mView;
	}
	
	@RequestMapping("/praise/ajax/add")
	@ResponseBody
	public Result praiseAdd(Integer targetId,Integer type) {
		EduComment eduComment=new EduComment();
		eduComment.setComment_id(targetId);
		eduComment.setType(type);
		boolean b=true;
		Result result=new Result();
		if (b) {
			articleService.editPraise(targetId);
			commentService.praiseEdit(eduComment);
			b=true;
		}
		System.out.println(eduComment.getPraise_count());
		result.setSuccess(b);
		return result;
	}
	
	@RequestMapping("/web/comment/ajax/addcomment")
	public String addcomment(HttpSession session,HttpServletResponse response,int pCommentId,String content,int type,int otherId) {
		Edu_User edu_User = (Edu_User) session.getAttribute("login_success");
		Edu_Comment edu_Comment=new Edu_Comment();
		edu_Comment.setP_comment_id(pCommentId);
		edu_Comment.setContent(content);
		edu_Comment.setOther_id(otherId);
		edu_Comment.setType(type);
		edu_Comment.setAddtime(new Date());
		edu_Comment.setUserId(edu_User);
		articleService.editCommentNum(otherId);
		commentService.save(edu_Comment);
		return "redirect:/front/articleinfo/"+otherId;
	}
	
	@RequestMapping("/web/comment/ajax/commentreply")
	public ModelAndView commentreply(int pCommentId,int otherId) {
		ModelAndView mView=new ModelAndView();
		Map map=new HashMap<>();
	    map.put("p_comment_id", pCommentId);
	    map.put("other_id", otherId);
	    List<Edu_Comment>listChild=commentService.listChildComment(map);
	    mView.setViewName("/web/comment/comment_reply");
	    mView.addObject("commentList", listChild);
		return mView;
	}
	@RequestMapping("/web/comment/ajax/addChildComment")
	public String addChildComment(HttpServletRequest request,HttpSession session,HttpServletResponse response,int pCommentId,String content,int type,int otherId) {
		Edu_User edu_User = (Edu_User) session.getAttribute("login_success");
		Edu_Comment edu_Comment=new Edu_Comment();
		edu_Comment.setP_comment_id(pCommentId);
		edu_Comment.setContent(content);
		edu_Comment.setOther_id(otherId);
		edu_Comment.setType(type);
		edu_Comment.setAddtime(new Date());
		edu_Comment.setUserId(edu_User);
		commentService.replyEdit(pCommentId);
		commentService.addChildComment(edu_Comment);
		return "redirect:/front/articleinfo/"+otherId;
	}
	
	@RequestMapping("/front/showcoulist")
	public ModelAndView showcoulist() {
		ModelAndView mView=new ModelAndView();
		mView.setViewName("web/index/image");
		return mView;
	}

}
