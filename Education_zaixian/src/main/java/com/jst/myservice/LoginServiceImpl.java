package com.jst.myservice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.Sys_UsersMapper;
import com.jst.model.Sys_user;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private Sys_UsersMapper user; 
	@Override
	public Sys_user getUpwd(String uname) {
		return user.getPwd(uname);
	}
	@Override
	public List<Sys_user> listAll(Map map) {
		return	user.listAll(map);
	}
//	
	@Override
	public void addUser(Sys_user u) {
		user.addUser(u);
	}
	/* (non-Javadoc)
	 * 
	 * 通过uid删除用户
	 * @see com.jst.myservice.LoginService#deleteById(int)
	 */
	@Override
	public void deleteById(int uid) {
		user.deleteById(uid);
	}
//	@Override
//	public int listAllRows() {
//		
//		return user.listAllRows();
//	}
	@Override
	public Sys_user selectUserById(int uid) {
		return user.selectUserById(uid);
		
	}
	@Override
	public void updateUser(Sys_user users) {
		
		user.updateUser(users);
		
	}

}
