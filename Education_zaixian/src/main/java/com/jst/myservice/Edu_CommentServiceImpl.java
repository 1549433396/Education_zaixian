package com.jst.myservice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.Edu_CommentMapper;
import com.jst.model.Edu_Comment;

@Service
public class Edu_CommentServiceImpl implements Edu_CommentService{

	@Autowired
	private Edu_CommentMapper commentMapper;
	
	@Override
	public List<Edu_Comment> list(Map map) {
		List<Edu_Comment> list = commentMapper.list(map);
		return list;
	}

	@Override
	public Edu_Comment getById(int comment_id) {
		Edu_Comment edu_Comment = commentMapper.getById(comment_id);
		return edu_Comment;
	}

	@Override
	public void delete(int comment_id) {
		commentMapper.delete(comment_id);
	}

	@Override
	public void update(Edu_Comment edu_Comment) {
		commentMapper.update(edu_Comment);
	}

	@Override
	public List<Edu_Comment> selectType(int type) {
		List<Edu_Comment> list = commentMapper.selectType(type);
		return list;
	}

	@Override
	public Edu_Comment selectId(int comment_id) {
		Edu_Comment list = commentMapper.selectId(comment_id);
		return list;
	}

}
