package com.jst.mapper.teacher;

import java.util.List;

import com.jst.model.Subject;

public interface SubjectMapper {

	Subject getIdBySM(int id);
	
	List<Subject> listAllSM();
	
}
