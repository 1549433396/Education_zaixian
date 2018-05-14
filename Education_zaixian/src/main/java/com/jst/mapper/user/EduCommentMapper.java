package com.jst.mapper.user;

import java.util.List;

import com.jst.model.EduComment;



public interface EduCommentMapper {
	//	                  查询
	public List<EduComment> listAll(int edqcid);
	//        删除
	public void delete(int ecid);
}
