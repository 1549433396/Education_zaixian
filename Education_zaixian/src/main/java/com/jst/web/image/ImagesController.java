package com.jst.web.image;


import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jst.model.Edu_Website_Images;
import com.jst.model.Edu_Website_Images_Type;
import com.jst.myservice.images.EduWebsiteImagesService;
import com.jst.myservice.images.EduWebsiteImagesTypeService;

@Controller
public class ImagesController {

	@Autowired
	private EduWebsiteImagesService eduWebsiteImagesService;

	@Autowired
	private EduWebsiteImagesTypeService eduWebsiteImagesTypeService;

	@RequestMapping("/admin/website/imagesPage")
	public ModelAndView imagesPage(@RequestParam(required=true,defaultValue="1")Integer page,HttpServletRequest request,Map map) {
		ModelAndView mView=new ModelAndView();
		map=init(request, map);
		PageHelper.startPage(page, 5);
		List<Edu_Website_Images>listAll=eduWebsiteImagesService.listAll(map);
		PageInfo<Edu_Website_Images>pageInfo=new PageInfo<>(listAll);
		List<Edu_Website_Images_Type>listType=eduWebsiteImagesTypeService.listAll();
		mView.addObject("listType", listType);
		mView.addObject("listAll", listAll);
		mView.addObject("page", pageInfo);
		mView.setViewName("/manager/imagesList");
		return mView;
	}

	@RequestMapping("/admin/deleteImageAll/{chk_value}")
	public String deleteAll(@PathVariable Integer[] chk_value) {
		if (chk_value == null && chk_value.length <= 0) {
			return "redirect:/admin/website/imagesPage";
		}
		for (Integer integer : chk_value) {
			System.out.println(integer);
		}
		eduWebsiteImagesService.deleteAll(chk_value);
		return "redirect:/admin/website/imagesPage";
	}

	@RequestMapping("/admin/deleteImage/{image_id}")
	public String deleteImage(@PathVariable int image_id) {
		eduWebsiteImagesService.delete(image_id);
		return "redirect:/admin/website/imagesPage";
	}

	@RequestMapping("/admin/getByIdImage/{image_id}")
	public ModelAndView getByIdImage(@PathVariable int image_id) {
		ModelAndView mView=new ModelAndView();
		mView.setViewName("/manager/imageEdit");
		List<Edu_Website_Images_Type>listAll=eduWebsiteImagesTypeService.listAll();
		Edu_Website_Images edu_Website_Images=eduWebsiteImagesService.getById(image_id);
		mView.addObject("edu_Website_Images", edu_Website_Images);
		mView.addObject("listType", listAll);
		return mView;
	}

	@RequestMapping(value="/admin/editImages",method=RequestMethod.POST)
	public String editImages(@RequestParam("file1")MultipartFile file1,Edu_Website_Images edu_Website_Images,HttpServletRequest request,int type_ids) {
		String blah1=request.getParameter("hiddens");
		Edu_Website_Images_Type edu_Website_Images_Type=new Edu_Website_Images_Type();
		edu_Website_Images_Type.setType_id(type_ids);
		edu_Website_Images.setType_id(edu_Website_Images_Type);
		Date date=new Date();
		String path=request.getRealPath("/images/upload/image/20151019/");
		String filename1=file1.getOriginalFilename();
		if(filename1.equals("")||filename1==null){
			edu_Website_Images.setImage_url(blah1);
			edu_Website_Images.setPreview_url(blah1);
		}else{
			edu_Website_Images.setImage_url("/images/upload/image/20151019/"+filename1);
			edu_Website_Images.setPreview_url("/images/upload/image/20151019/"+filename1);
			File newfile1=new File(path,filename1);
			try{
				file1.transferTo(newfile1);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		eduWebsiteImagesService.update(edu_Website_Images);
		return "redirect:/admin/website/imagesPage";
	}

	@RequestMapping(value="/admin/saveImage",method=RequestMethod.POST)
	public String saveImage(@RequestParam("file1")MultipartFile file1,Edu_Website_Images edu_Website_Images,HttpServletRequest request) {
		String type_id=request.getParameter("type_ids");
		String series_number=request.getParameter("series_numbers");
		String filename1=file1.getOriginalFilename();
		String path=request.getRealPath("/images/upload/image/20151019/");
		File newfile1=new File(path,filename1);
		try{
			file1.transferTo(newfile1);
		}catch(Exception e){
			e.printStackTrace();
		}
		edu_Website_Images.setImage_url("/images/upload/image/20151019/"+filename1);
		edu_Website_Images.setPreview_url("/images/upload/image/20151019/"+filename1);
		Edu_Website_Images_Type edu_Website_Images_Type=new Edu_Website_Images_Type();
		edu_Website_Images_Type.setType_id(Integer.parseInt(type_id));
		edu_Website_Images.setType_id(edu_Website_Images_Type);
		edu_Website_Images.setSeries_number(Integer.parseInt(series_number));
		eduWebsiteImagesService.save(edu_Website_Images);
		return "redirect:/admin/website/imagesPage";
	}
	
	

	@RequestMapping("/admin/getByImgeType")
	public ModelAndView getByImgeType() {
		ModelAndView mView=new ModelAndView();
		mView.setViewName("/manager/imageAdd");
		List<Edu_Website_Images_Type>listAll=eduWebsiteImagesTypeService.listAll();
		mView.addObject("listType", listAll);
		return mView;
	}
	
	@RequestMapping("/admin/showsEdit/{image_id}/{shows}")
	public String shows(@PathVariable int image_id,@PathVariable int shows) {
		Edu_Website_Images edu_Website_Images=new Edu_Website_Images();
		if (shows==1) {
			shows=0;
			edu_Website_Images.setShows(shows);
		}else if (shows==0) {
			shows=1;
			edu_Website_Images.setShows(shows);
		}
		edu_Website_Images.setImage_id(image_id);
		eduWebsiteImagesService.showsEdit(edu_Website_Images);
		return "redirect:/admin/website/imagesPage";
	}
	
	private Map init(HttpServletRequest request,Map map){
		String title=request.getParameter("title");
		String type_id=request.getParameter("type_ids");
		if (title!=null) {
			request.getParameter("title");
		}
		if (type_id=="-1") {
			request.getParameter("type_id");
		}
		map.put("title", title);
		map.put("type_id",type_id);
		return map;
	}
}
