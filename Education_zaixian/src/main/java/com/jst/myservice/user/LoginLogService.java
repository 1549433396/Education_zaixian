package com.jst.myservice.user;

import java.util.List;

import com.jst.model.LoginLog;

public interface LoginLogService {
	public List<LoginLog> listAll(int user_id);

	public void delete(int lid);
}
