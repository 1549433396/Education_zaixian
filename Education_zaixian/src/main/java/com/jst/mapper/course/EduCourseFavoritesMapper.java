package com.jst.mapper.course;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jst.model.EduCourseFavorites;

public interface EduCourseFavoritesMapper {
    

    int deleteByPrimaryKey(Integer id);

    int insert(EduCourseFavorites record);

    int insertSelective(EduCourseFavorites record);


    EduCourseFavorites selectByPrimaryKey(Integer id);



    int updateByPrimaryKeySelective(EduCourseFavorites record);

    int updateByPrimaryKey(EduCourseFavorites record);
}