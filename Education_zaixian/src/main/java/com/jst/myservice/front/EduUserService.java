package com.jst.myservice.front;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jst.model.Edu_User;

public interface EduUserService {
	//ͨ�������ȡ������е�¼
	public Edu_User getPwd(String userName);
	//ע���û�
	public void addUser(Edu_User user);
	
	public List<Edu_User> shows(Map map);

	
}
