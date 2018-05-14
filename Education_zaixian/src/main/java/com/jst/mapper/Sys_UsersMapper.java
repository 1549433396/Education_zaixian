package com.jst.mapper;

import java.util.List;
import java.util.Map;

import com.jst.model.Sys_user;

public interface Sys_UsersMapper {
	//通过账号查询密码
	public Sys_user getPwd(String uname);
	//查询所有用户(有分页)
	public List<Sys_user> listAll(Map map);
	//查询有多少条用户数据
	int listAllRows();
	//添加用户
	public void addUser(Sys_user users);
	//通过用户查询所有权限
	public Sys_user getPermission(int uid);
	//通过用户查询菜单的所有权限
	public Sys_user getPermissionCaiDan(int uid);
	//删除用户
	public void deleteById(int id);
	//通过用户id查询用户
	public Sys_user selectUserById(int uid);
	//根据用户id修改用户信息
	void updateUser(Sys_user users);

}
