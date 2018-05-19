package com.jst.mapper.user;

import java.util.List;

import com.jst.model.LoginLog;




public interface LoginLogMapper {
     public List<LoginLog> listAll(int user_id);

	public void delete(int lid);
}
