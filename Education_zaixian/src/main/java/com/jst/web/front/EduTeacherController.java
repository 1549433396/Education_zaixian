package com.jst.web.front;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jst.model.Subject;
import com.jst.model.Teacher;
import com.jst.myservice.teacher.CourseService;
import com.jst.myservice.teacher.EduTeacherService;
import com.jst.myservice.teacher.SysSubjectService;

@Controller
public class EduTeacherController {
	
	@Autowired
	private EduTeacherService EduTeacherService;
	private SysSubjectService SysSubjectService;
	@Autowired
	private CourseService CourseService;
	
	public SysSubjectService getSysSubjectService() {
		return SysSubjectService;
	}
	@Resource(name="teacherSubjectService")
	public void setSysSubjectService(SysSubjectService sysSubjectService) {
		SysSubjectService = sysSubjectService;
	}

	@RequestMapping("/front/teacher")
	public String teacher(@RequestParam(required=true,defaultValue="1")Integer page,Model model){
		PageHelper.startPage(page, 4);
		List<Teacher> list = EduTeacherService.listAll();
		PageInfo<Teacher> p = new PageInfo<Teacher>(list);
		model.addAttribute("page", p);
		List<Integer> is = new ArrayList<>();
		for (int i = 1; i <= p.getPages(); i++) {
			is.add(i);
		}
		model.addAttribute("totalPage", page);
		model.addAttribute("pageNum", is);
		model.addAttribute("teacherList", list);
		System.out.println(list);
		model.addAttribute("subjectList", SysSubjectService.listAllParent());
		return "/web/teacher/teacher_list";
	}
	
	@RequestMapping("/front/teacher/getById/{id}")
	public ModelAndView getById(@PathVariable int id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/web/teacher/teacher_info");
		mav.addObject("teacher", EduTeacherService.getById(id));
		mav.addObject("courseList", CourseService.listCou(id));
		return mav;
	}
	
	@RequestMapping("/front/getParBySub")
	public ModelAndView ParentToSub(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		int subject_id = Integer.valueOf(request.getParameter("queryTeacher_subjectId"));
		mav.setViewName("/web/teacher/teacher_list");
		List<Teacher> list = new ArrayList<Teacher>();
		List<Subject> subjects  = SysSubjectService.getParBySub(subject_id);
		for (Subject subject : subjects) {
			System.out.println("subject_id----------"+subject.getSubject_id());
			List<Teacher> teacher = EduTeacherService.listById(subject.getSubject_id());
			for (Teacher teacher2 : teacher) {
				if (teacher2 != null) {
					list.add(teacher2);
				}
			}
		}
		mav.addObject("teacherList", list);
		mav.addObject("subjectList", SysSubjectService.listAllParent());
		return mav;
	}
	
	@RequestMapping("/front/teacher/page")
	public String page() {
		return "/common/front_page2";
	}
	
}
