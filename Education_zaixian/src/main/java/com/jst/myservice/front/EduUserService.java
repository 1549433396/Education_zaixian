package com.jst.myservice.front;

import com.jst.model.Edu_User;

public interface EduUserService {
	//ͨ�������ȡ������е�¼
	public Edu_User getPwd(String userName);
	//ע���û�
	public void addUser(Edu_User user);
	
}
