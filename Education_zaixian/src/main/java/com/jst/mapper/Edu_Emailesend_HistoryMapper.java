package com.jst.mapper;

import java.util.List;
import java.util.Map;

import com.jst.model.Edu_Emailesend_History;
import com.jst.model.Edu_User;
import com.jst.qiantai.EduUser;

public interface Edu_Emailesend_HistoryMapper {
	
	public List<Edu_Emailesend_History> list(Map map);
	public Edu_Emailesend_History getById(int id);
	public void save(Edu_Emailesend_History e);
	public void delete(int id);
	public void update(Edu_Emailesend_History edu_Emailesend_History);
	public List<Edu_User> selectLimit();

}
