package com.jst.mapper;

import java.util.List;
import java.util.Map;

import com.jst.model.Sys_user;

public interface Sys_UsersMapper {
	//ͨ���˺Ų�ѯ����
	public Sys_user getPwd(String uname);
	//��ѯ�����û�(�з�ҳ)
	public List<Sys_user> listAll(Map map);
	//��ѯ�ж������û�����
	int listAllRows();
	//����û�
	public void addUser(Sys_user users);
	//ͨ���û���ѯ����Ȩ��
	public Sys_user getPermission(int uid);
	//ͨ���û���ѯ�˵�������Ȩ��
	public Sys_user getPermissionCaiDan(int uid);
	//ɾ���û�
	public void deleteById(int id);
	//ͨ���û�id��ѯ�û�
	public Sys_user selectUserById(int uid);
	//�����û�id�޸��û���Ϣ
	void updateUser(Sys_user users);

}
