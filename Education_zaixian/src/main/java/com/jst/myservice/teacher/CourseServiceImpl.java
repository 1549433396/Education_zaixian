package com.jst.myservice.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.teacher.CourseMapper;
import com.jst.model.Course;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseMapper CourseMapper;
	
	@Override
	public List<Course> listCou(int id) {
		return CourseMapper.listCou(id);
	}

	
}
