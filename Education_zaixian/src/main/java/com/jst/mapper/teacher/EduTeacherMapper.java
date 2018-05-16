package com.jst.mapper.teacher;

import java.util.List;

import com.jst.model.Teacher;

public interface EduTeacherMapper {

	List<Teacher> listAll();
	
	Teacher getById(int id);
	
	List<Teacher> listById(int subject_id);
	
	List<Teacher> listTea(int id);
	
}
