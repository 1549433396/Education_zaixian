package com.jst.myservice.front;

import com.jst.model.Edu_User;

public interface EduUserService {
	//通过邮箱获取密码进行登录
	public Edu_User getPwd(String userName);
	//注册用户
	public void addUser(Edu_User user);
	
}
