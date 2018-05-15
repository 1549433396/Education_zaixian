package com.jst.web.image;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jst.model.Edu_Website_Images_Type;
import com.jst.myservice.images.EduWebsiteImagesTypeService;

@Controller
public class ImageTypeController {
	
	@Autowired
	private EduWebsiteImagesTypeService eduWebsiteImagesTypeService;

	@RequestMapping("/admin/imagetype/getlist")
	public ModelAndView getlist(@RequestParam(required=true,defaultValue="1")Integer page) {
		PageHelper.startPage(page, 10);
       List<Edu_Website_Images_Type>listAll=eduWebsiteImagesTypeService.listAll();
       PageInfo<Edu_Website_Images_Type>pageInfo=new PageInfo<>(listAll);
       ModelAndView mView=new ModelAndView();
       mView.addObject("listType", listAll);
       mView.addObject("page", pageInfo);
       mView.setViewName("/manager/imageTypeList");
       return mView;
	}
	
	@RequestMapping("/admin/deleteType/{type_id}")
	public String delete(@PathVariable int type_id) {
		eduWebsiteImagesTypeService.delete(type_id);
		return "redirect:/admin/imagetype/getlist";
	}
	
	@RequestMapping("/admin/getByIdType/{type_id}")
	public ModelAndView getById(@PathVariable int type_id) {
		ModelAndView mView=new ModelAndView();
		Edu_Website_Images_Type edu_Website_Images_Type=eduWebsiteImagesTypeService.getById(type_id);
		mView.addObject("imageType", edu_Website_Images_Type);
		mView.setViewName("/manager/imageTypeEdit");
		return mView;
	}
	
	@RequestMapping("/admin/imagetype/edit")
	public String edit(Edu_Website_Images_Type edu_Website_Images_Type,String type_name,int type_id) {
		edu_Website_Images_Type.setType_id(type_id);
		edu_Website_Images_Type.setType_name(type_name);
		eduWebsiteImagesTypeService.update(edu_Website_Images_Type);
		return "redirect:/admin/imagetype/getlist";
	}
	@RequestMapping("/admin/imagetype/turn")
	public String turn() {
		return "/manager/imageTypeAdd";
	}
	@RequestMapping("/admin/imagetype/add")
	public String add(Edu_Website_Images_Type edu_Website_Images_Type,String type_names) {
		edu_Website_Images_Type.setType_name(type_names);
		eduWebsiteImagesTypeService.save(edu_Website_Images_Type);
		return "redirect:/admin/imagetype/getlist";
	}
	
}
