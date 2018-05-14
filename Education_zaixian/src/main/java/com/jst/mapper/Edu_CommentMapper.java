package com.jst.mapper;

import java.util.List;
import java.util.Map;

import com.jst.model.Edu_Comment;

public interface Edu_CommentMapper {
	
	public List<Edu_Comment> list(Map map);
	public Edu_Comment getById(int comment_id);
	public void delete(int comment_id);
	public void update(Edu_Comment edu_Comment);
	public List<Edu_Comment> selectType(int type);

}
