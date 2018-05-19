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
//	查看回复
	public List<QuestionsComment> getqId(int qid);
//	采纳为最佳
	public void updateIsBest(int qcid);
	 //点赞
	public void updatepraise(int id);
	public List<QuestionsComment> getById2(int qid);
	public List<QuestionsComment> getById3(int qid);
	public List<QuestionsComment> getListById(int commentId);
//	回复数量修改
	public void updateReplyCount(int qcid);
	public List<QuestionsComment> getListById2(int commentId);
}
