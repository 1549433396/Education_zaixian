package com.jst.mapper.course;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jst.model.EduCourseStudyhistory;

public interface EduCourseStudyhistoryMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(EduCourseStudyhistory record);

    int insertSelective(EduCourseStudyhistory record);



    EduCourseStudyhistory selectByPrimaryKey(Integer id);




    int updateByPrimaryKeySelective(EduCourseStudyhistory record);

    int updateByPrimaryKeyWithBLOBs(EduCourseStudyhistory record);

    int updateByPrimaryKey(EduCourseStudyhistory record);
}