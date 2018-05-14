package com.jst.mapper.user;

import java.util.List;
import java.util.Map;

import com.jst.model.Edu_User;



public interface EduUserMapper {
	//     查询
	public List<Edu_User> listAll(Map map);
	//     添加
	public void save(Edu_User eduUser);
	//     删除
	public void delete(int user_id);
	//	根据id查询全部
	public Edu_User getById(int user_id);
	//     修改密码
	public void update(Map map);
	//	         冻结
	public void updateFozen(Map map);
}
