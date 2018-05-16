package com.jst.myservice.teacher;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.teacher.TeacherMapper;
import com.jst.model.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherMapper TeacherMapper;
	
	@Override
	public List<Teacher> listAllTS(Map map) {
		return TeacherMapper.listAllTM(map);
	}

	@Override
	public void deleteTS(int id) {
		TeacherMapper.deleteTM(id);
	}

	@Override
	public Teacher getIdByTS(int id) {
		return TeacherMapper.getIdByTM(id);
	}

	@Override
	public void updateTS(Teacher t) {
		TeacherMapper.updateTM(t);
	}

	@Override
	public void insertTS(Teacher t) {
		TeacherMapper.insertTM(t);
	}

}
