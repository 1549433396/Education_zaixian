package com.jst.myservice.statistical;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.statistical.StatisticalFigureMapper;
import com.jst.model.Edu_User;
import com.jst.model.LoginLog;

@Service
public class StatisticalFigureServiceImpl implements StatisticalFigureService{
	
	@Autowired
	private StatisticalFigureMapper sMapper;

	@Override
	public List<Edu_User> shows(Map map) {
		List<Edu_User> list=sMapper.shows(map);
		return list;
	}

	@Override
	public List<LoginLog> LoginShows(Map map) {
		List<LoginLog> list=sMapper.LoginShows(map);
		return list;
	}
}
