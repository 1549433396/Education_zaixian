package com.jst.mapper;
import java.util.List;
import java.util.Map;

import com.jst.model.Sys_role;

public interface Sys_RoleMapper {
	//���ݽ�ɫ��ѯ����Ȩ��
	Sys_role selectById(int id);
	//��ѯ���н�ɫ
	List<Sys_role> allRole();
	//��ӽ�ɫ
	int role_Add(Sys_role r);
	//��r_p���������
	void r_p_Add(Sys_role role);
	//�����û�id��ѯ��ɫ
//	Role queryById(int id);
//	Role queryByIds(int id);
	//���ݽ�ɫidɾ����ɫ
	void deleteById(int rid);
	//��Ȩʱ�޸��û��Ľ�ɫ
	void updateUserRid(Map<String, Integer> map);
}
