package com.jst.mapper.course;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jst.model.EduCourseSubject;

public interface EduCourseSubjectMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(EduCourseSubject record);

    int insertSelective(EduCourseSubject record);


    EduCourseSubject selectByPrimaryKey(Integer id);



    int updateByPrimaryKeySelective(EduCourseSubject record);

    int updateByPrimaryKey(EduCourseSubject record);
}