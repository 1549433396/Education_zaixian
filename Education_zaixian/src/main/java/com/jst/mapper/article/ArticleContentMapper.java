package com.jst.mapper.article;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jst.model.Edu_Article_Content;

//��������
@Service
public interface ArticleContentMapper {
	
	public Edu_Article_Content getById(int article_id);
	
	public List<Edu_Article_Content> listAll();

}
