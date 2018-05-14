package com.jst.mapper.course;

import com.jst.model.EduCourseKpoint;

public interface EduCourseKpointMapper {


    int deleteByPrimaryKey(Integer kpointId);

    int insert(EduCourseKpoint record);

    int insertSelective(EduCourseKpoint record);



    EduCourseKpoint selectByPrimaryKey(Integer kpointId);




    int updateByPrimaryKeySelective(EduCourseKpoint record);

    int updateByPrimaryKeyWithBLOBs(EduCourseKpoint record);

    int updateByPrimaryKey(EduCourseKpoint record);
}