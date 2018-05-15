package com.jst.myservice.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.article.ArticleContentMapper;
import com.jst.model.Edu_Article_Content;

@Service
public class ArticleContentServiceImpl implements ArticleContentService{
	
	@Autowired
	private ArticleContentMapper articleContentMapper;

	public Edu_Article_Content getById(int article_id) {
		Edu_Article_Content articleContent=articleContentMapper.getById(article_id);
		return articleContent;
	}

	public List<Edu_Article_Content> listAll() {
		List<Edu_Article_Content> list=articleContentMapper.listAll();
		return list;
	}

}
