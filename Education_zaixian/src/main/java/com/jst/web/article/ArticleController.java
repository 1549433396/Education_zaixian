package com.jst.web.article;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import com.jst.model.Edu_Article;
import com.jst.model.Edu_Article_Content;
import com.jst.myservice.article.ArticleContentService;
import com.jst.myservice.article.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService aService;

	@Autowired
	private ArticleContentService cService;

	@RequestMapping("/admin/article/showlist")
	public ModelAndView listAll(@RequestParam(required=true,defaultValue="1")Integer page,HttpServletRequest request){
		Map map=init(request);
		PageHelper.startPage(page, 10);
		List<Edu_Article>listA=aService.listAll(map);
		PageInfo<Edu_Article>pageInfo=new PageInfo<>(listA);
		ModelAndView mView=new ModelAndView("/manager/articleList");
		mView.addObject("listA", listA);
		mView.addObject("page", pageInfo);
		return mView;
	}

	@RequestMapping("/admin/getById/{article_id}")
	public ModelAndView getById(@PathVariable int article_id) {
		Edu_Article article=aService.getById(article_id);
		ModelAndView mView=new ModelAndView();
		mView.addObject("article", article);
		mView.setViewName("/manager/articleEdit");
		return mView;
	}

	@RequestMapping(value="/admin/edit",method=RequestMethod.POST)
	public String edit(@RequestParam("file")MultipartFile file,HttpServletRequest request,Edu_Article edu_Article) {
		String contents=request.getParameter("contents");
		edu_Article.setCreate_time(new Date());
		Edu_Article_Content edu_Article_Content=new Edu_Article_Content();
		edu_Article_Content.setArticle_id(edu_Article.getArticle_id());
		edu_Article_Content.setContent(contents);
		edu_Article.setAcontent(edu_Article_Content);
		String filename=file.getOriginalFilename();
		SimpleDateFormat sFormat=new SimpleDateFormat("yyyyMMdd");
		String blah1=request.getParameter("hiddens");
		String path=request.getRealPath("/images/upload/article/");
		String newPath = path+"/"+sFormat.format(new Date())+"/";//指定新路径
		File file1 = new File(newPath);//定义一个文件流
		if(!file1.exists()){
			file1.mkdir();
		}
		if (filename.equals("")||filename==null) {
			edu_Article.setImage_url(blah1);
		}else {
			File newfile=new File(file1,filename);
			try{
				if(!newfile.exists()){
					   newfile.createNewFile();
					}
					file.transferTo(newfile);
			}catch(Exception e){
				e.printStackTrace();
			}
			edu_Article.setImage_url("/upload/"+filename);
		}
		aService.edit(edu_Article);
		return "redirect:/admin/article/showlist";
	}

	@RequestMapping("/admin/article/initcreate")
	public String initcreate() {
		return "/manager/articleAdd";
	}

	@RequestMapping(value="/admin/save",method=RequestMethod.POST)
	public String save(@RequestParam("file")MultipartFile file,HttpServletRequest request,Edu_Article edu_Article) {
		String contents=request.getParameter("contents");
		String filename=file.getOriginalFilename();
		SimpleDateFormat sFormat=new SimpleDateFormat("yyyyMMdd");
//		String path=getServletContext().getRealPath("/");
		String path=request.getRealPath("/images/upload/article/");
		String newPath = path+"/"+sFormat.format(new Date()); 
		File file1 = new File(newPath);//定义一个文件流
		if(!file1.exists()){
			file1.mkdir();
		}
		File newfile=new File(file1,filename);
		try{
			if(!newfile.exists()){
			   newfile.createNewFile();
			}
			file.transferTo(newfile);
		}catch(Exception e){
			e.printStackTrace();
		}
		edu_Article.setCreate_time(new Date());
		Edu_Article_Content edu_Article_Content=new Edu_Article_Content();
		edu_Article_Content.setContent(contents);
		edu_Article.setAcontent(edu_Article_Content);
		edu_Article.setImage_url("/images/upload/article/"+sFormat.format(new Date())+"/"+filename);
		aService.save(edu_Article);
		aService.addContent(edu_Article);
		return "redirect:/admin/article/showlist";
	}

	@RequestMapping("/admin/delete/{article_id}")
	public String delete(@PathVariable int article_id) {
		aService.delete(article_id);
		return "redirect:/admin/article/showlist";
	}

	@RequestMapping("/admin/deleteAll/{chk_value}")
	public String deleteAll(@PathVariable Integer[] chk_value) {
		if (chk_value == null && chk_value.length <= 0) {
			return "redirect:/admin/article/showlist";
		}
		for (Integer integer : chk_value) {
			System.out.println(integer);
		}
		//ֱ�Ӵ�����
		aService.deleteAll(chk_value);
		return "redirect:/admin/article/showlist";
	}
	
	@RequestMapping("/admin/releaseEdit/{article_id}/{releases}")
	public String releaseEdit(@PathVariable int article_id,@PathVariable int releases) {
		Edu_Article edu_Article=new Edu_Article();
		if (releases==1) {
			releases=0;
			edu_Article.setPublish_time(new Date());
			edu_Article.setReleases(releases);
		}else if (releases==0) {
			releases=1;
			edu_Article.setPublish_time(new Date());
			edu_Article.setReleases(releases);
		}
		edu_Article.setArticle_id(article_id);
		aService.releaseEdit(edu_Article);
		return "redirect:/admin/article/showlist";
	}

	public Map init(HttpServletRequest request) {
		String article_type=request.getParameter("article_type");
		String title=request.getParameter("title");
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		Map map=new HashMap<>();
		if (title!=null) {
			request.setAttribute("title", title);
		}
		Edu_Article edu_Article=new Edu_Article();
		map.put("start", start);
		map.put("end", end);
		map.put("article_type",article_type);
		map.put("title", title);
		return map;
	}
}
