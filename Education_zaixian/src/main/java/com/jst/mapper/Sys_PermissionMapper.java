package com.jst.mapper;

import java.util.List;

import com.jst.model.Sys_function;

/**
 * @author Administrator
 *
 */
public interface Sys_PermissionMapper {
	//通过角色查询权限
//	List<Permission> selectById(int id);
	//查询所有权限
	List<Sys_function> listAll();
//	//查询菜单权限
//	List<Permission> listAllById(int id);
//	//添加权限
//	void insertPermission(Permission permission);
//	//根据用户查询生成菜单的所有权限
//	List<Permission> queryById(int id);
	//根据角色id删除所有权限
	void deleteById(int rid);
	
}
