package com.jst.myservice.user;

import java.util.List;

import com.jst.model.EduComment;

public interface EduCommentService {
	//    查询
	public List<EduComment> listAll(int edqcid);
	//        删除
	public void delete(int ecid);
}
