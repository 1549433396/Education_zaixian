package com.jst.myservice.question;

import java.util.List;
import java.util.Map;

import com.jst.model.QuestionsComment;

public interface QuestionsCommentService {
	//        查询
	List<QuestionsComment> listAll(Map map);
	//        添加
	void save(QuestionsComment questionsComment);
	//        删除
	void delete(int qcid);
	//    	根据id查询全部
	QuestionsComment getById(int qcid);
	//        修改
	void update(QuestionsComment questionsComment);
//	查看回复
	public List<QuestionsComment> getqId(int qid);
//	采纳为最佳
	void updateIsBest(int qcid);
	 //点赞
	 public void updatepraise(int id);
}
