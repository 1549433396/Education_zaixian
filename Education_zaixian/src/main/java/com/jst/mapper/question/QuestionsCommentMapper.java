package com.jst.mapper.question;

import java.util.List;
import java.util.Map;

import com.jst.model.QuestionsComment;


public interface QuestionsCommentMapper {
	//	                  查询
	public List<QuestionsComment> listAll(Map map);
	//        添加
	public void save(QuestionsComment questionsComment);
	//        删除
	public void delete(int qcid);
	//    	根据id查询全部
	public QuestionsComment getById(int qcid);
	//        修改
	public void update(QuestionsComment questionsComment);
}
