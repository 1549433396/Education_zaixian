package com.jst.myservice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.Sys_RoleMapper;
import com.jst.model.Sys_role;

@Service
public class RoleServiceImpl implements RoleService {


	@Autowired
	private Sys_RoleMapper r;

	@Override
	public List<Sys_role> allRole() {
		return r.allRole();
	}

	@Override
	public int Add_Role(Sys_role role) {
		return r.role_Add(role);
	}
	@Override
	public void r_p_Add(Sys_role role) {
		r.r_p_Add(role);
	}
	@Override
	public void deleteById(int rid) {
		r.deleteById(rid);
	}

	@Override
	public Sys_role selectRoleById(int rid) {
		return r.selectById(rid);
	}

	public void updateUserRid(Map<String, Integer> map) {
		r.updateUserRid(map);
		
	}
}
