package com.jst.myservice.course;

import java.util.List;
import java.util.Map;

import com.jst.model.EduTeacher;
import com.jst.model.SysSubject;

public interface SysSubjectService {
	//��ȡ���пγ�
	List<SysSubject> getAllSubject();
	
	//��ȡ���еĽ�ʦ����
	List<EduTeacher> gEduTeachers();
	
//��ȡ���пγ�(ǰ̨����)
	List<SysSubject> getAllSubjects(Map map);
}
