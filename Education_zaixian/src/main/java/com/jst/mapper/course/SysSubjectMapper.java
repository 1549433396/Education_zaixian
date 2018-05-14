package com.jst.mapper.course;

import java.util.List;
import java.util.Map;

import com.jst.model.EduTeacher;
import com.jst.model.SysSubject;

public interface SysSubjectMapper {
	//通过课程id获取课程
	SysSubject getById(int id);
	//获取所有的课程
	List<SysSubject> getAllSubect();
	
	//获取所有教师的信息
	List<EduTeacher> getAllList();
	
	//获取所有的专业(前台数据)
	public List<SysSubject> getALLSubject(Map map);
}
