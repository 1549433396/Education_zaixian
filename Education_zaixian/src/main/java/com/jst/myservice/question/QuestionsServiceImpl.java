package com.jst.myservice.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.question.QuestionsMapper;
import com.jst.model.Questions;
import com.jst.model.QuestionsTag;
import com.jst.utils.Result;
import com.jst.ztree.ZtreeNode;

@Service
public class QuestionsServiceImpl implements QuestionsService{

	@Autowired
	private QuestionsMapper questionsMapper;
	
	@Override
	public List<Questions> listAll(Map map) {
        List<Questions> list=questionsMapper.listAll(map);    
		return list;
	}

	@Override
	public void save(Questions questions) {
		questionsMapper.save(questions);

	}

	@Override
	public void delete(int qid) {
		questionsMapper.delete(qid);

	}

	@Override
	public Questions getById(int qid) {
		Questions questions=questionsMapper.getById(qid);
		return questions;
	}

	@Override
	public void update(Questions questions) {
		questionsMapper.update(questions);

	}

	@Override
	public List<Questions> getlistAll(int type) {
		List<Questions> list=questionsMapper.getlistAll(type);
		return list;
	}

	@Override
	public Questions getlistById(int qid) {
		Questions questions=questionsMapper.getlistById(qid);
		return questions;
	}

	@Override
	public List<Questions> list() {
		List<Questions> list=questionsMapper.list();
		
		return list;
	}

	@Override
	public void updatePraise(int id) {
		questionsMapper.updatePraise(id);
		
	}

	@Override
	public int getMaxId() {
		int maxId=questionsMapper.getMaxId();
		return maxId;
	}

	@Override
	public void saveRelation(Map map) {
		questionsMapper.saveRelation(map);
		
	}

	@Override
	public void updateReplyCount(int qcid) {
		questionsMapper.updateReplyCount(qcid);
		
	}

	/*@Override
	public List<Questions> listType() {
		List<Questions> list=questionsMapper.listType();
		return list;
	}*/

	

}
