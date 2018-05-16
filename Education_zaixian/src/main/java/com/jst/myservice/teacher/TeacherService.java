package com.jst.myservice.teacher;

import java.util.List;
import java.util.Map;

import com.jst.model.Teacher;

public interface TeacherService {

	List<Teacher> listAllTS(Map map);
	
	void deleteTS(int id);
	
	Teacher getIdByTS(int id);
	
	void updateTS(Teacher t);
	
	void insertTS(Teacher t);
	
}
