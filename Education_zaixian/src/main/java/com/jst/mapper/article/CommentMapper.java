package com.jst.mapper.article;

import java.util.List;
import java.util.Map;

import com.jst.model.EduComment;
import com.jst.model.Edu_Comment;

public interface CommentMapper {
	
	public List<Edu_Comment> listAll();
	public Edu_Comment getById(int comment_id);
	public List<Edu_Comment> getByOther(int other_id);
	public void save(Edu_Comment edu_Comment);
	public void addChildComment(Edu_Comment edu_Comment);
	public List<Edu_Comment> listChildComment(Map map);
	public void praiseEdit(EduComment eduComment);
	public void replyEdit(int comment_id);
}
