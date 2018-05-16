package com.jst.myservice.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.teacher.SubjectMapper;
import com.jst.model.Subject;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectMapper SubjectMapper;
	
	@Override
	public Subject getIdBySS(int id) {
		return SubjectMapper.getIdBySM(id);
	}

	@Override
	public List<Subject> listAllSS() {
		return SubjectMapper.listAllSM();
	}

}
