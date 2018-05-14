package com.jst.mapper.question;

import java.util.List;

import com.jst.model.QuestionsTag;

public interface QuestionsTagMapper {
	//	          查询
	public List<QuestionsTag> listAll();
	//      添加
	public void save(QuestionsTag questionsTag);
	//      删除
	public void delete(int qtid);
	//      根据id查询全部
	public QuestionsTag getById(int qtid);
	//      修改
	public void update(QuestionsTag questionsTag);
}
