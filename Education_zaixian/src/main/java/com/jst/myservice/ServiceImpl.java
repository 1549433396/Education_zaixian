package com.jst.myservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.Sys_PermissionMapper;
import com.jst.mapper.Sys_UsersMapper;
import com.jst.model.Sys_function;
import com.jst.model.Sys_user;
@Service
public class ServiceImpl implements ServiceDemo {

	
	@Autowired
	private Sys_UsersMapper user;
	
	@Autowired
	private Sys_PermissionMapper permissionMapper;

	/* (non-Javadoc)
	 * @see com.jst.myservice.ServiceDemo#getList()
	 * 查询所有权限
	 */
	@Override
	public List<Sys_function> getList() {
		List<Sys_function> list = permissionMapper.listAll();
		return list;
	}

//	@Override
//	public List<Permission> getListById(int id) {
//		return pm.listAllById(id);
//	}
	
	
	/* (non-Javadoc)
	 * @see com.jst.myservice.ServiceDemo#getUserListById(int)
	 * 通过用户查询所有权限
	 */
	public Sys_user getList(int uid) {
		System.out.println(user.getPermission(uid));
		return user.getPermission(uid);
	}
	
	/**
	 * 通过用户ID查询生成菜单的权限
	 * @param uid
	 * @return
	 */
	public Sys_user getListCaiDan(int uid) {
		return user.getPermissionCaiDan(uid);
	}

	

}
