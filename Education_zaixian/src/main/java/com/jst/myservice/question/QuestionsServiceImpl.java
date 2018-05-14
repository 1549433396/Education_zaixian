package com.jst.myservice.question;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.question.QuestionsMapper;
import com.jst.model.Questions;

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

	/*@Override
	public List<Questions> listType() {
		List<Questions> list=questionsMapper.listType();
		return list;
	}*/

	

}
