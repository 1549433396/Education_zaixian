package com.jst.mapper;

import java.util.List;

import com.jst.model.Sys_function;

/**
 * @author Administrator
 *
 */
public interface Sys_PermissionMapper {
	//ͨ����ɫ��ѯȨ��
//	List<Permission> selectById(int id);
	//��ѯ����Ȩ��
	List<Sys_function> listAll();
//	//��ѯ�˵�Ȩ��
//	List<Permission> listAllById(int id);
//	//���Ȩ��
//	void insertPermission(Permission permission);
//	//�����û���ѯ���ɲ˵�������Ȩ��
//	List<Permission> queryById(int id);
	//���ݽ�ɫidɾ������Ȩ��
	void deleteById(int rid);
	
}
