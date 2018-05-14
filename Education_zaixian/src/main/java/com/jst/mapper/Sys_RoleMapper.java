package com.jst.mapper;
import java.util.List;
import java.util.Map;

import com.jst.model.Sys_role;

public interface Sys_RoleMapper {
	//根据角色查询所有权限
	Sys_role selectById(int id);
	//查询所有角色
	List<Sys_role> allRole();
	//添加角色
	int role_Add(Sys_role r);
	//向r_p表插入数据
	void r_p_Add(Sys_role role);
	//根据用户id查询角色
//	Role queryById(int id);
//	Role queryByIds(int id);
	//根据角色id删除角色
	void deleteById(int rid);
	//授权时修改用户的角色
	void updateUserRid(Map<String, Integer> map);
}
