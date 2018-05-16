package com.jst.mapper.teacher;

import java.util.List;
import java.util.Map;

import com.jst.model.Teacher;

public interface TeacherMapper {

	List<Teacher> listAllTM(Map map);
	
	void deleteTM(int id);
	
	Teacher getIdByTM(int id);
	
	void updateTM(Teacher t);
	
	void insertTM(Teacher t);
	
}
