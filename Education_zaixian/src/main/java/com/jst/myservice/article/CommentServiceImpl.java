package com.jst.myservice.article;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.article.CommentMapper;
import com.jst.model.EduComment;
import com.jst.model.Edu_Comment;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public List<Edu_Comment> listAll() {
		List<Edu_Comment>list=commentMapper.listAll();
		return list;
	}

	@Override
	public Edu_Comment getById(int comment_id) {
		Edu_Comment edu_Comment=commentMapper.getById(comment_id);
		return edu_Comment;
	}

	@Override
	public List<Edu_Comment> getByOther(int other_id) {
		List<Edu_Comment>listAll=commentMapper.getByOther(other_id);
		return listAll;
	}

	@Override
	public void save(Edu_Comment edu_Comment) {
		commentMapper.save(edu_Comment);
	}

	@Override
	public List<Edu_Comment> listChildComment(Map map) {
		List<Edu_Comment> list=commentMapper.listChildComment(map);
		return list;
	}

	@Override
	public void praiseEdit(EduComment eduComment) {
		commentMapper.praiseEdit(eduComment);
	}

	@Override
	public void addChildComment(Edu_Comment edu_Comment) {
		commentMapper.addChildComment(edu_Comment);		
	}

	@Override
	public void replyEdit(int comment_id) {
		commentMapper.replyEdit(comment_id);
	}
}
