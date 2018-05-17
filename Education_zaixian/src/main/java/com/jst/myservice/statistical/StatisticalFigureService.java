package com.jst.myservice.statistical;

import java.util.List;
import java.util.Map;

import com.jst.model.Edu_User;
import com.jst.model.LoginLog;

public interface StatisticalFigureService {
	
	public List<Edu_User> shows(Map map);

	public List<LoginLog> LoginShows(Map map);
}
