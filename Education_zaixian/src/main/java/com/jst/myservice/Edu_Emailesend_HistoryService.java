package com.jst.myservice;

import java.util.List;
import java.util.Map;

import com.jst.model.Edu_Emailesend_History;
import com.jst.model.Edu_User;

public interface Edu_Emailesend_HistoryService {
	
	public List<Edu_Emailesend_History> list(Map map);
	public Edu_Emailesend_History getById(int id);
	public void save(Edu_Emailesend_History edu_Emailesend_History);
	public void delete(int id);
	public void update(Edu_Emailesend_History edu_Emailesend_History);
	public List<Edu_User> selectLimit();
}
