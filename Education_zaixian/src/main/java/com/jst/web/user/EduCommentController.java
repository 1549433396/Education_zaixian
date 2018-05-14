package com.jst.web.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jst.model.EduComment;
import com.jst.myservice.user.EduCommentService;

@Controller
@RequestMapping("/admin/EduComment")
public class EduCommentController {
	
	   @Autowired
	   private EduCommentService eduCommentService;
	   /*
	    * 查询
	    */
	   @RequestMapping("/EduCommentList")
       public ModelAndView EduCommentList(int edqcid) {
    	 ModelAndView mv=new ModelAndView();
    	 List<EduComment> listeduComment=eduCommentService.listAll(edqcid);
    	 mv.addObject("listeduComment", listeduComment);
    	 mv.setViewName("EduCommentList");
		 return mv;
	}
       /*
        * 删除
        */
	   @RequestMapping("/delEduComment")
	   public String delEduComment(int ecid) {
		eduCommentService.delete(ecid);
		return "redirect:EduCommentList";
	}
}
