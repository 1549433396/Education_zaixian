package com.jst.mapper.course;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jst.model.EduCourseNote;

public interface EduCourseNoteMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(EduCourseNote record);

    int insertSelective(EduCourseNote record);



    EduCourseNote selectByPrimaryKey(Integer id);




    int updateByPrimaryKeySelective(EduCourseNote record);

    int updateByPrimaryKeyWithBLOBs(EduCourseNote record);

    int updateByPrimaryKey(EduCourseNote record);
}