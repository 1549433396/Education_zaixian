package com.jst.myservice.question;

import java.util.List;

import com.jst.model.QuestionsTag;
import com.jst.ztree.ZtreeNode;

public interface QuestionsTagService {
	//    查询
//	public List<QuestionsTag> listAll();
	
	public List<ZtreeNode> listAll();
	//      添加
	public void save(QuestionsTag questionsTag);
	//      删除
	public void delete(int qtid);
	//      根据id查询全部
	public QuestionsTag getById(int qtid);
	//      修改
	public void update(QuestionsTag questionsTag);
}
