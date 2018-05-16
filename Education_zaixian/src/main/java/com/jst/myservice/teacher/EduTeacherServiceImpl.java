package com.jst.myservice.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.teacher.EduTeacherMapper;
import com.jst.model.Teacher;

@Service
public class EduTeacherServiceImpl implements EduTeacherService{

	@Autowired
	private EduTeacherMapper EduTeacherMapper;
	
	@Override
	public List<Teacher> listAll() {
		return EduTeacherMapper.listAll();
	}

	@Override
	public Teacher getById(int id) {
		return EduTeacherMapper.getById(id);
	}

	@Override
	public List<Teacher> listById(int subject_id) {
		return EduTeacherMapper.listById(subject_id);
	}

	@Override
	public List<Teacher> listTea(int id) {
		return EduTeacherMapper.listTea(id);
	}

}
