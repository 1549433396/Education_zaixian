package com.jst.myservice.course;

import java.util.List;
import java.util.Map;

import com.jst.model.EduCourse;
import com.jst.model.EduCourseKpoint;
import com.jst.model.EduCourseNote;
import com.jst.model.Edu_course_kpoint;

public interface EduCourseService {
	//获取所有的课程详情
	List<EduCourse> getAllList(Map map);
	
	//添加课程
	int insertCourse(EduCourse eduCourse);
	
	//向edu_course_teacher表插入数据
	void addEduCourseTeacher(Map<String, Integer> map);
	
	//删除课程
	void deleteCourse(int cid);
	//查询某一个课程
	EduCourse selectById(int cid);
	//获取所有课程的节点
//	EduCourseKpoint selectNodeById(int eid);
//获取所有节点
	List<Edu_course_kpoint> queryCourseKpointByCourseId(int courseId);
//获取某一个节点视频
	Edu_course_kpoint queryCourseKpointById(int kpointId);
	//修改视频节点
	void updateKpoint(Edu_course_kpoint courseKpoint);
//修改课程
	void editCourse(EduCourse educourse);
//修改课程讲师
	void editEduCourseTeacher(Map<String, Integer> map);
//添加笔记
	void addNote(EduCourseNote eduCourseNote);
//查询笔记
	EduCourseNote queryNote(EduCourseNote eduCourseNote);
//修改笔记
	void updateNote(EduCourseNote eduCourseNote);
//插入一条视屏章节
	void insertKpoint(Edu_course_kpoint edu_course_kpoint);
//删除一个视频节点
	void deleteKpoint(String ids);

}
