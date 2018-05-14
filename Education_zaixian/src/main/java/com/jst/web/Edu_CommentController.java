package com.jst.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jst.model.Edu_Comment;
import com.jst.myservice.Edu_CommentService;

@Controller
public class Edu_CommentController {
	
	@Autowired
	private Edu_CommentService commentService;
	
	@RequestMapping("/admin/comment/query")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap();
		map = initMap(request, map);
		System.out.println("map.values():"+map.values());
		List<Edu_Comment> list = commentService.list(map);
		mv.setViewName("/manager/edu_commentList");
		mv.addObject("list",list);
		return mv;
	}
	
	@RequestMapping("/admin/comment/delete/{comment_id}")
	public String delete(@PathVariable("comment_id")int comment_id) {
		commentService.delete(comment_id);
		return "redirect:/admin/comment/query";
	}
	
	@RequestMapping("/admin/comment/del")
	public void del(HttpServletRequest request,HttpServletResponse response) {
		String items = request.getParameter("delitems");
		String[] strs = items.split(",");
		for (int i = 0; i < strs.length; i++) {
			int a = Integer.parseInt(strs[i]);
			commentService.delete(a);
		}
	}
	
	@RequestMapping("/admin/comment/init/{comment_id}")
	public ModelAndView init(@PathVariable("comment_id")int comment_id) {
		ModelAndView mv = new ModelAndView();
		Edu_Comment comment = commentService.getById(comment_id);
		mv.setViewName("/manager/edu_commentEdit");
		mv.addObject("comment",comment);
		return mv;
	}
	
	@RequestMapping("/admin/comment/update")
	public String update(Edu_Comment edu_Comment) {
		
		System.out.println("123"+edu_Comment);
		commentService.update(edu_Comment);
		return "redirect:/admin/comment/query";
	}
	
    private Map initMap(HttpServletRequest request,Map map) {
    	String qname = request.getParameter("qname");
    	String type = request.getParameter("type");
    	String email = request.getParameter("email");
    	String start = request.getParameter("start");
    	String end = request.getParameter("end");
    	System.out.println("开始时间："+start);
    	System.out.println("结束时间："+end);
    	if (type!=null&&type.trim().length()!=0) {
			int type2 = Integer.parseInt(type);
			request.setAttribute("type",type2);
			map.put("type",type2);
		}
    	if (qname!=null&&qname.trim().length()>0) {
			request.setAttribute("qname",qname);
			map.put("qname",qname);
		}
    	if (email!=null&&email.trim().length()>0) {
			request.setAttribute("email",email);
			map.put("email",email);
		}
    	if (start!=null&&start.trim().length()>0) {
			request.setAttribute("start",start);
			map.put("start",start);
		}
    	if (end!=null&&end.trim().length()>0) {
			request.setAttribute("end",end);
			map.put("end",end);
		}
		return map;
	
    } 
}
