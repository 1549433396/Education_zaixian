package com.jst.myservice.article;

import java.util.List;

import com.jst.model.Edu_Article_Content;

//ÎÄÕÂÄÚÈİ
public interface ArticleContentService {
 
public Edu_Article_Content getById(int article_id);
	
	public List<Edu_Article_Content> listAll();

}
