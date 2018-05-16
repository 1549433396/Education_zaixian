package com.jst.myservice.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.teacher.SysTeacherSubjectMapper;
import com.jst.model.Subject;

@Service(value="teacherSubjectService")
public class SysSubjectServiceImpl implements SysSubjectService{

	@Autowired
	private SysTeacherSubjectMapper SysTeacherSubjectMapper;
	
	@Override
	public Subject getById(int id) {
		return SysTeacherSubjectMapper.getById(id);
	}

	@Override
	public List<Subject> listSM() {
		return SysTeacherSubjectMapper.listSM();
	}

	@Override
	public List<Subject> listAllParent() {
		return SysTeacherSubjectMapper.listAllParent();
	}

	@Override
	public List<Subject> getParBySub(int id) {
		return SysTeacherSubjectMapper.getParBySub(id);
	}

}
