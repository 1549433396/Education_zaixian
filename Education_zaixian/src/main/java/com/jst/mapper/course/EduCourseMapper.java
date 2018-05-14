package com.jst.mapper.course;

import java.util.List;
import java.util.Map;

import com.jst.model.EduCourse;
import com.jst.model.EduCourseNote;
import com.jst.model.Edu_course_kpoint;
/**
 * @author Administrator
 *课程dao
 */
public interface EduCourseMapper {
	//获取所有的课程
	List<EduCourse> getAllList(Map map);
	//向edu_course_teacher表插入数据
	void addE_T(Map<String, Integer> map);
	//向eduE_T中修改讲师
	void updateTeacher(Map<String, Integer> map);
	//插入一条课程
	int insert(EduCourse record);
	//删除课程
	void deleteCourse(int cid);
	//删除教师课程表里的课程
	void deleteE_T(int cid);
	//查询某一个课程
	EduCourse selectByCourseId(int cid);
	//通过课程查询该课程的节点
	List<Edu_course_kpoint> queryKpoint(int courseId);
	//获取某一个视频
	Edu_course_kpoint queryCourseKpoint(int kpointId);
	//修改某个节点
	void updateKpoint(Edu_course_kpoint courseKpoint);
	//修改课程
	void updateCourse(EduCourse educourse);
	//添加笔记
	void addNote(EduCourseNote eduCourseNote);
	//查询所有的笔记
	EduCourseNote queryNote(EduCourseNote eduCourseNote);
	//修改笔记
	void updateNote(EduCourseNote eduCourseNote);
	//插入视频节点
	void insertKpoint(Edu_course_kpoint edu_course_kpoint);
	//删除视频节点
	void deleteKpoint(String ids);

	
	


}