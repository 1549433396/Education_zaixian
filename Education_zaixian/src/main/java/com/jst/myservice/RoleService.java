package com.jst.myservice;

import java.util.List;
import java.util.Map;

import com.jst.model.Sys_role;

public interface RoleService {
	//��ѯ���н�ɫ
	List<Sys_role> allRole();
	//��ӽ�ɫ
	int Add_Role(Sys_role r);
	void r_p_Add(Sys_role role);
	//���ݽ�ɫidɾ����ɫ
	void deleteById(int rid);
	//���ݽ�ɫid��ѯȨ��
	Sys_role selectRoleById(int rid);
	//��Ȩʱ�޸��û��Ľ�ɫ
	public void updateUserRid(Map<String, Integer> map);
	
}
