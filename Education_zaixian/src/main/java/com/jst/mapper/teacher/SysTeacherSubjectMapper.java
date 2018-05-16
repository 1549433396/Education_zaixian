package com.jst.mapper.teacher;

import java.util.List;

import com.jst.model.Subject;

public interface SysTeacherSubjectMapper {

	Subject getById(int id);
	
	List<Subject> listSM();
	
	List<Subject> listAllParent();
	
	List<Subject> getParBySub(int id);
	
}
