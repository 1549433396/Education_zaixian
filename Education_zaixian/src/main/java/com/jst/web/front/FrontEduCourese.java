package com.jst.web.front;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jst.model.EduCourseNote;
import com.jst.model.Edu_User;
import com.jst.model.Edu_course_kpoint;
import com.jst.myservice.course.EduCourseService;
import com.jst.myservice.course.SysSubjectService;
import com.jst.utils.Result;
@Controller
public class FrontEduCourese {
	
	@Autowired
	private EduCourseService eduCourseService;
	
	@Autowired
	private SysSubjectService sysSubjectService;
	@RequestMapping("/course")
	public String course(Model model,HttpServletRequest request){
		Map map = getMap(request);
		//这里加map没用
		model.addAttribute("subjectList",sysSubjectService.getAllSubjects(map));
		model.addAttribute("courseList",eduCourseService.getAllList(map));
		model.addAttribute("teacherList", sysSubjectService.gEduTeachers());
		return "/web/course/courses-list";
	}
	
	public Map getMap(HttpServletRequest request) {
		Map map = new HashMap();
		String courseName = request.getParameter("queryCourse.courseName");
		String teacherid = request.getParameter("queryCourse.teacherId");
		String subjectId = request.getParameter("queryCourse.subjectId");
		if (courseName != null) {
			map.put("qname", courseName);
			request.setAttribute("queryCourse.courseName", courseName);
		}
		if (teacherid != null) {
			map.put("teacherid", teacherid);
			request.setAttribute("queryCourse.teacherId", teacherid);
		}
		if (subjectId != null) {
			map.put("subjectId", subjectId);
			request.setAttribute("queryCourse.subjectId", subjectId);
		}
		return map;
	}
	
	
	@RequestMapping("/front/couinfo/{course_id}")
	public String courseInfo(@PathVariable int course_id,Model model){
		model.addAttribute("course",eduCourseService.selectById(course_id));
		List<Edu_course_kpoint> parentKpointList = new ArrayList<Edu_course_kpoint>();
		List<Edu_course_kpoint> kpointList = eduCourseService.queryCourseKpointByCourseId(course_id);
		if (kpointList != null && kpointList.size() > 0) {
			// 遍历 一级目录
			for (Edu_course_kpoint temp : kpointList) {
				if (temp.getParent_id() == 0) {
					parentKpointList.add(temp);
				}
			}

			// 遍历 获取二级目录
			for (Edu_course_kpoint tempParent : parentKpointList) {
				for (Edu_course_kpoint temp : kpointList) {
					if (temp.getParent_id() == tempParent.getKpoint_id()) {
						tempParent.getList().add(temp);
					}
				}
			}
			model.addAttribute("parentKpointList", parentKpointList);
		}
		return "/web/course/course-infor";
	}
	
	
	/**
	 * 添加笔记
	 * @return
	 */
	@RequestMapping("/courseNote/ajax/addnote")
	@ResponseBody
	public Result addNote(EduCourseNote eduCourseNote,HttpSession session,
			HttpServletRequest request) {
		eduCourseNote.setUpdate_time(new Date());
		Edu_User edu_User = (Edu_User) session.getAttribute("login_success");
		eduCourseNote.setUser_id(edu_User.getUser_id());
		System.out.println(eduCourseNote);
		String val = request.getParameter("val");
		if (Integer.parseInt(val) == 0) {
			eduCourseService.addNote(eduCourseNote);
		}else {
			eduCourseService.updateNote(eduCourseNote);
		}
		
		
		return new Result(true, "success", eduCourseNote.getContent());
	}
	
	/**
	 * 查询笔记
	 * @return
	 */
	@RequestMapping("/courseNote/ajax/querynote")
	@ResponseBody
	public Result QueryNote(EduCourseNote eduCourseNote,HttpSession session) {
		eduCourseNote.setUpdate_time(new Date());
		Edu_User edu_User = (Edu_User) session.getAttribute("login_success");
		eduCourseNote.setUser_id(edu_User.getUser_id());
		eduCourseNote  = eduCourseService.queryNote(eduCourseNote);
		return new Result(true, "success", eduCourseNote);
	}
	
	
	@RequestMapping("/uc/index")
	public String to(EduCourseNote eduCourseNote,HttpSession session) {
		
		return "/web/ucenter/user-info";
	}

}
