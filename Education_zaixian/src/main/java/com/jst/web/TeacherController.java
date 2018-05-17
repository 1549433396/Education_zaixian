package com.jst.web;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jst.model.Subject;
import com.jst.model.Teacher;
import com.jst.myservice.teacher.SubjectService;
import com.jst.myservice.teacher.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	@Autowired
	private SubjectService subjectService;

	@RequestMapping("/admin/teacher/list")
	public String listAll(@RequestParam(required=true,defaultValue="1")Integer page,Model model,HttpServletRequest request) throws ParseException {
		PageHelper.startPage(page, 10);
		Map map = new HashMap<>();
		System.out.println(page);
		String qname = request.getParameter("qname");
		String is_star = request.getParameter("is_star");
		String create_time = request.getParameter("create_time");
		String create_times = request.getParameter("create_times");
		PageInfo<Teacher> p = null;
		System.out.println(qname+"-------------"+is_star+"---------------"+create_time+"---------------"+create_times);
		if (qname != null && !qname.equals("")) {
			map.put("qname", qname);
			request.setAttribute("qname", qname);
		}
		if (is_star != null && !is_star.equals("")) {
			map.put("is_star", Integer.valueOf(is_star));
			request.setAttribute("is_star", Integer.valueOf(is_star));
		}
		if (create_time != null && !create_time.equals("")) {
			if (create_times != null && !create_times.equals("")) {
				map.put("create_time", create_time);
				map.put("create_times", create_times);
				request.setAttribute("create_time", create_time);
				request.setAttribute("create_times", create_times);
			}
		}
		List<Teacher> list = list = teacherService.listAllTS(map);
		p = new PageInfo<Teacher>(list);
		System.out.println(p.getPages());
		model.addAttribute("page", p);
		List<Integer> is = new ArrayList<>();
		for (int i = 1; i <= p.getPages(); i++) {
			is.add(i);
		}
		model.addAttribute("totalCount", is);
		model.addAttribute("pageNum", page);
		model.addAttribute("teas", list);
		return "/manager/teacherList";
	}

	@RequestMapping("/admin/teacher/updateTM")
	public String updateTM(@RequestParam MultipartFile file,Teacher t,HttpServletRequest request){
		String subject_id = request.getParameter("sid");
		Subject subject = new Subject();
		subject.setSubject_id(Integer.valueOf(subject_id));
		Date update_time = new Date();

		//图片上传
		//获得物理路径webapp所在路径
		String path = request.getRealPath("/upload/");
		//String pathRoot = "";
		String pic_path = "";
		if (!file.isEmpty()) {
			//生成uuid作为文件名称
			//String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			//获得文件类型
			String contextType = file.getOriginalFilename();
			//获得文件后缀名
			//String pathName = contextType.substring(contextType.lastIndexOf(".")+1,contextType.length());
			//pathRoot = path + "/" + uuid + "." + pathName;
			File file2 = new File(path, contextType);
			pic_path = "/upload/" + contextType;
			try {
				file.transferTo(file2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Teacher teas = new Teacher(t.getName(), t.getTh_name(), t.getTh_pw(), t.getEducation(), t.getCareer(), t.getIs_star(), pic_path, 0, null, update_time, subject, t.getSort());
		teas.setId(t.getId());
		teacherService.updateTS(teas);
		return "redirect:/admin/teacher/list";
	}

	@RequestMapping("/admin/teacher/insertTM")
	public String insertTM(@RequestParam MultipartFile file,Teacher t,HttpServletRequest request){
		String subject_id = request.getParameter("sid");
		String sort = request.getParameter("sorts");
		Subject subject = new Subject();
		subject.setSubject_id(Integer.valueOf(subject_id));
		Date create_time = new Date();
		//图片上传
		//获得物理路径webapp所在路径
		String path = request.getRealPath("/upload/");
		//String pathRoot = "";
		String pic_path = "";
		if (!file.isEmpty()) {
			//生成uuid作为文件名称
			//String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			//获得文件类型
			String contextType = file.getOriginalFilename();
			//获得文件后缀名
			//String pathName = contextType.substring(contextType.lastIndexOf(".")+1,contextType.length());
			//pathRoot = path + "/" + uuid + "." + pathName;
			File file2 = new File(path, contextType);
			pic_path = "/upload/" + contextType;
			try {
				file.transferTo(file2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Teacher teas = new Teacher(t.getName(), t.getTh_name(), t.getTh_pw(), t.getEducation(), t.getCareer(), t.getIs_star(), pic_path, 0, create_time, null, subject, Integer.valueOf(sort));
		teacherService.insertTS(teas);
		return "redirect:/admin/teacher/list";
	}

	@RequestMapping("/admin/teacher/getIdByTM/{id}")
	public ModelAndView getIdByTM(@PathVariable int id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ts", teacherService.getIdByTS(id));
		mav.addObject("subs", subjectService.listAllSS());
		mav.setViewName("/manager/teacherEdit");
		return mav;
	}

	@RequestMapping("/admin/teacher/deleteTM/{id}")
	public String deleteTM(@PathVariable int id) {
		teacherService.deleteTS(id);
		return "redirect:/admin/teacher/list";
	}

	@RequestMapping("/admin/teacher/toadd")
	public ModelAndView teacherAdd() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("subs", subjectService.listAllSS());
		mav.setViewName("/manager/teacherAdd");
		return mav;
	}

	@RequestMapping("/subjects")
	@ResponseBody
	public List<Subject> subjects() {
		List<Subject> list = subjectService.listAllSS();
		return list;
	}

}
