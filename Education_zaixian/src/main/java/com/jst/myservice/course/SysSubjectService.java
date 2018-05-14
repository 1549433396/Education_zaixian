package com.jst.myservice.course;

import java.util.List;
import java.util.Map;

import com.jst.model.EduTeacher;
import com.jst.model.SysSubject;

public interface SysSubjectService {
	//获取所有课程
	List<SysSubject> getAllSubject();
	
	//获取所有的教师详情
	List<EduTeacher> gEduTeachers();
	
//获取所有课程(前台数据)
	List<SysSubject> getAllSubjects(Map map);
}
