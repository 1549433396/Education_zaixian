package com.jst.myservice;

import java.util.List;
import java.util.Map;

import com.jst.model.Sys_user;

public interface LoginService {
	public Sys_user getUpwd(String uname);
//	//查询所有用户（加分页）
	public List<Sys_user> listAll(Map map);
	public void addUser(Sys_user users);
//	//通过id删除用户
	public void deleteById(int uid);
//	//查询共有多少条数据
//	int listAllRows();
//	//通过用户id查询用户
	Sys_user selectUserById(int uid);
//	//通过用户id修改用户信息
	void updateUser(Sys_user users);
}
