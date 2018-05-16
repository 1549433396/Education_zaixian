package com.jst.myservice.teacher;

import java.util.List;

import com.jst.model.Teacher;

public interface EduTeacherService {

	List<Teacher> listAll();
	
	Teacher getById(int id);
	
	List<Teacher> listById(int subject_id);
	
	List<Teacher> listTea(int id);
	
}
