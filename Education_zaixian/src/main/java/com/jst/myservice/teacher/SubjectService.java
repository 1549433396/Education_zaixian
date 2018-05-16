package com.jst.myservice.teacher;

import java.util.List;

import com.jst.model.Subject;

public interface SubjectService {

	Subject getIdBySS(int id);
	
	List<Subject> listAllSS();
	
}
