package com.jst.web.imageFront;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jst.model.Edu_Article;
import com.jst.model.Edu_Website_Images;
import com.jst.myservice.images.EduWebsiteImagesService;

@Controller
public class ImageFrontController {
	
	@Autowired
	private EduWebsiteImagesService eduWebsiteImagesService;
	
	@RequestMapping("/front")
	public ModelAndView front(){
		ModelAndView mView=new ModelAndView();
		List<Edu_Website_Images>listAll=eduWebsiteImagesService.WebListAll();
		mView.addObject("listAll", listAll);
		mView.setViewName("web/index/index");
		return mView;
	}
}
