package com.jst.myservice.teacher;

import java.util.List;

import com.jst.model.Subject;

public interface SysSubjectService {

	Subject getById(int id);

	List<Subject> listSM();
	
	List<Subject> listAllParent();
	
	List<Subject> getParBySub(int parent_id);

}
