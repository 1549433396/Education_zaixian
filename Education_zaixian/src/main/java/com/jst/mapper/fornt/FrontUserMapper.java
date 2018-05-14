package com.jst.mapper.fornt;

import java.util.List;

import com.jst.model.Edu_User;
import com.jst.model.SysSubject;

public interface FrontUserMapper {
	//通过用户名获取密码
	public Edu_User getPwd(String userName);
	//注册用户	
	public void addUser(Edu_User user);
	
	
}
