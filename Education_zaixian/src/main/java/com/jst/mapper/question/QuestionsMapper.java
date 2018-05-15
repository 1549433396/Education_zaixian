package com.jst.mapper.question;

import java.util.List;

import java.util.Map;

import com.jst.model.Questions;
import com.jst.utils.Result;

public interface QuestionsMapper {
	//	               查询
	public List<Questions> listAll(Map map);
//	public List<Questions> listType();
	//       添加
	public void save(Questions questions);
	//       删除
	public void delete(int qid);
	//	根据id查询全部
	public Questions getById(int qid);
	//       修改
	public void update(Questions questions);
	
	public List<Questions> getlistAll(int type);
	
	 public Questions getlistById(int qid);
	 
	 public List<Questions> list();
	 //点赞
	 public void updatePraise(int id);
}
