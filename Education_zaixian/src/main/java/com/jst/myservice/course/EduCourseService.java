package com.jst.myservice.course;

import java.util.List;
import java.util.Map;

import com.jst.model.EduCourse;
import com.jst.model.EduCourseKpoint;
import com.jst.model.EduCourseNote;
import com.jst.model.Edu_course_kpoint;

public interface EduCourseService {
	//��ȡ���еĿγ�����
	List<EduCourse> getAllList(Map map);
	
	//��ӿγ�
	int insertCourse(EduCourse eduCourse);
	
	//��edu_course_teacher���������
	void addEduCourseTeacher(Map<String, Integer> map);
	
	//ɾ���γ�
	void deleteCourse(int cid);
	//��ѯĳһ���γ�
	EduCourse selectById(int cid);
	//��ȡ���пγ̵Ľڵ�
//	EduCourseKpoint selectNodeById(int eid);
//��ȡ���нڵ�
	List<Edu_course_kpoint> queryCourseKpointByCourseId(int courseId);
//��ȡĳһ���ڵ���Ƶ
	Edu_course_kpoint queryCourseKpointById(int kpointId);
	//�޸���Ƶ�ڵ�
	void updateKpoint(Edu_course_kpoint courseKpoint);
//�޸Ŀγ�
	void editCourse(EduCourse educourse);
//�޸Ŀγ̽�ʦ
	void editEduCourseTeacher(Map<String, Integer> map);
//��ӱʼ�
	void addNote(EduCourseNote eduCourseNote);
//��ѯ�ʼ�
	EduCourseNote queryNote(EduCourseNote eduCourseNote);
//�޸ıʼ�
	void updateNote(EduCourseNote eduCourseNote);
//����һ�������½�
	void insertKpoint(Edu_course_kpoint edu_course_kpoint);
//ɾ��һ����Ƶ�ڵ�
	void deleteKpoint(String ids);

}
