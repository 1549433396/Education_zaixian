package com.jst.mapper.course;

import java.util.List;
import java.util.Map;

import com.jst.model.EduTeacher;
import com.jst.model.SysSubject;

public interface SysSubjectMapper {
	//ͨ���γ�id��ȡ�γ�
	SysSubject getById(int id);
	//��ȡ���еĿγ�
	List<SysSubject> getAllSubect();
	
	//��ȡ���н�ʦ����Ϣ
	List<EduTeacher> getAllList();
	
	//��ȡ���е�רҵ(ǰ̨����)
	public List<SysSubject> getALLSubject(Map map);
}
