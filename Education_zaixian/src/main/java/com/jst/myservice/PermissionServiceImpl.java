package com.jst.myservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.Sys_PermissionMapper;
@Service
public class PermissionServiceImpl implements PermissionService {

	
	@Autowired
	private Sys_PermissionMapper per;
	
//	@Override
//	public List<Permission> selectAll() {
//		return p.listAll();
//	}

//	@Override
//	public void insertPermission(Permission permission) {
//		p.insertPermission(permission);
//	}

	@Override
	public void deleteById(int rid) {
		per.deleteById(rid);
		
	}
	
}
