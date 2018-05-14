package com.jst.myservice;

import java.util.List;

import com.jst.model.Sys_function;
import com.jst.model.Sys_user;

public  interface ServiceDemo {
	//查询所有权限
	public List<Sys_function> getList();
	//查询生成菜单的权限
//	public List<Permission> getListById(int id);
	//通过用户查询所有权限
	public Sys_user getList(int uid);
	//通过用户查询出生成菜单的权限
	public Sys_user getListCaiDan(int uid);
}
