package com.jst.myservice;

import java.util.List;

import com.jst.model.Sys_function;
import com.jst.model.Sys_user;

public  interface ServiceDemo {
	//��ѯ����Ȩ��
	public List<Sys_function> getList();
	//��ѯ���ɲ˵���Ȩ��
//	public List<Permission> getListById(int id);
	//ͨ���û���ѯ����Ȩ��
	public Sys_user getList(int uid);
	//ͨ���û���ѯ�����ɲ˵���Ȩ��
	public Sys_user getListCaiDan(int uid);
}
