package com.jst.myservice;

import java.util.List;
import java.util.Map;

import com.jst.model.Sys_user;

public interface LoginService {
	public Sys_user getUpwd(String uname);
//	//��ѯ�����û����ӷ�ҳ��
	public List<Sys_user> listAll(Map map);
	public void addUser(Sys_user users);
//	//ͨ��idɾ���û�
	public void deleteById(int uid);
//	//��ѯ���ж���������
//	int listAllRows();
//	//ͨ���û�id��ѯ�û�
	Sys_user selectUserById(int uid);
//	//ͨ���û�id�޸��û���Ϣ
	void updateUser(Sys_user users);
}
