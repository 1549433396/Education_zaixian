package com.jst.myservice.front;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.fornt.FrontUserMapper;
import com.jst.model.Edu_User;

@Service
public class EduUserServiceImpl implements EduUserService {
	@Autowired
	private FrontUserMapper frontUserMapper;

	@Override
	public Edu_User getPwd(String userNmae) {
		return frontUserMapper.getPwd(userNmae);
	}

	@Override
	public void addUser(Edu_User user) {
		frontUserMapper.addUser(user);
		
	}
}
