package com.jst.myservice.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.user.LoginLogMapper;
import com.jst.model.LoginLog;

@Service
public class LoginLogServiceImpl implements LoginLogService{
    
	@Autowired
	private LoginLogMapper loginLogMapper;
	
	@Override
	public List<LoginLog> listAll(int user_id) {
		List<LoginLog> list=loginLogMapper.listAll(user_id);
		return list;
	}

	@Override
	public void delete(int lid) {
		loginLogMapper.delete(lid);
		
	}
}
