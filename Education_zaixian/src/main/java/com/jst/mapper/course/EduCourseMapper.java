package com.jst.mapper.course;

import java.util.List;
import java.util.Map;

import com.jst.model.EduCourse;
import com.jst.model.EduCourseNote;
import com.jst.model.Edu_course_kpoint;
/**
 * @author Administrator
 *�γ�dao
 */
public interface EduCourseMapper {
	//��ȡ���еĿγ�
	List<EduCourse> getAllList(Map map);
	//��edu_course_teacher���������
	void addE_T(Map<String, Integer> map);
	//��eduE_T���޸Ľ�ʦ
	void updateTeacher(Map<String, Integer> map);
	//����һ���γ�
	int insert(EduCourse record);
	//ɾ���γ�
	void deleteCourse(int cid);
	//ɾ����ʦ�γ̱���Ŀγ�
	void deleteE_T(int cid);
	//��ѯĳһ���γ�
	EduCourse selectByCourseId(int cid);
	//ͨ���γ̲�ѯ�ÿγ̵Ľڵ�
	List<Edu_course_kpoint> queryKpoint(int courseId);
	//��ȡĳһ����Ƶ
	Edu_course_kpoint queryCourseKpoint(int kpointId);
	//�޸�ĳ���ڵ�
	void updateKpoint(Edu_course_kpoint courseKpoint);
	//�޸Ŀγ�
	void updateCourse(EduCourse educourse);
	//��ӱʼ�
	void addNote(EduCourseNote eduCourseNote);
	//��ѯ���еıʼ�
	EduCourseNote queryNote(EduCourseNote eduCourseNote);
	//�޸ıʼ�
	void updateNote(EduCourseNote eduCourseNote);
	//������Ƶ�ڵ�
	void insertKpoint(Edu_course_kpoint edu_course_kpoint);
	//ɾ����Ƶ�ڵ�
	void deleteKpoint(String ids);

	
	


}