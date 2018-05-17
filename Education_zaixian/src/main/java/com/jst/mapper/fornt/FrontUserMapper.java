package com.jst.mapper.fornt;

import java.util.List;
import java.util.Map;

import com.jst.model.Edu_User;
import com.jst.model.SysSubject;

public interface FrontUserMapper {
	//ͨ���û�����ȡ����
	public Edu_User getPwd(String userName);
	//ע���û�	
	public void addUser(Edu_User user);
	
	public Edu_User getById(int user_id);
	
}
