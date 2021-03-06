package com.jst.myservice.question;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.question.QuestionsCommentMapper;
import com.jst.model.QuestionsComment;

@Service
public class QuestionsCommentServiceImpl implements QuestionsCommentService{
    
	@Autowired
	private QuestionsCommentMapper questionsCommentMapper;
	
	@Override
	public List<QuestionsComment> listAll(Map map) {
		List<QuestionsComment> list=questionsCommentMapper.listAll(map);
		return list;
	}

	@Override
	public void save(QuestionsComment questionsComment) {
		questionsCommentMapper.save(questionsComment);
		
	}

	@Override
	public void delete(int qcid) {
		questionsCommentMapper.delete(qcid);
		
	}

	@Override
	public QuestionsComment getById(int qcid) {
		QuestionsComment questionsComment=questionsCommentMapper.getById(qcid);
		return questionsComment;
	}

	@Override
	public void update(QuestionsComment questionsComment) {
		questionsCommentMapper.update(questionsComment);
		
	}

	@Override
	public List<QuestionsComment> getqId(int qid) {
		List<QuestionsComment> list=questionsCommentMapper.getqId(qid);
		return list;
	}
	
	@Override
	public void updateIsBest(int qcid) {
		questionsCommentMapper.updateIsBest(qcid);
	}

	@Override
	public void updatepraise(int id) {
		questionsCommentMapper.updatepraise(id);
		
	}

	@Override
	public List<QuestionsComment> getById2(int qid) {
		List<QuestionsComment> list=questionsCommentMapper.getById2(qid);
		return list;
	}

	@Override
	public List<QuestionsComment> getById3(int qid) {
		List<QuestionsComment> list=questionsCommentMapper.getById3(qid);
		return list;
	}

	@Override
	public List<QuestionsComment> getListById(int commentId) {
		List<QuestionsComment> list=questionsCommentMapper.getListById(commentId);
		return list;
	}

	@Override
	public void updateReplyCount(int qcid) {
		questionsCommentMapper.updateReplyCount(qcid);
	}

	@Override
	public List<QuestionsComment> getListById2(int commentId) {
		List<QuestionsComment> list=questionsCommentMapper.getListById2(commentId);
		return list;
	}
}
