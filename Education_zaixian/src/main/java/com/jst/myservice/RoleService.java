package com.jst.myservice;

import java.util.List;
import java.util.Map;

import com.jst.model.Sys_role;

public interface RoleService {
	//查询所有角色
	List<Sys_role> allRole();
	//添加角色
	int Add_Role(Sys_role r);
	void r_p_Add(Sys_role role);
	//根据角色id删除角色
	void deleteById(int rid);
	//根据角色id查询权限
	Sys_role selectRoleById(int rid);
	//授权时修改用户的角色
	public void updateUserRid(Map<String, Integer> map);
	
}
