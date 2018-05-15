package com.jst.myservice.article;

import java.util.List;
import java.util.Map;

import com.jst.model.EduComment;
import com.jst.model.Edu_Article;

//����
public interface ArticleService {

    public void edit(Edu_Article map);
    
	public List<Edu_Article> listAll(Map map);
	
	public List<Edu_Article> alistAll();
	
	public void save(Edu_Article map);
	
	public void delete(int article_id);
	
	public Edu_Article getById(int article_id);

	public void addContent(Edu_Article map);
	
	public void updateContent(Edu_Article map);
	
	public void deleteAll(Integer[] chk_value);
	
	public void praiseEdit(EduComment eduComment);
	
	public void releaseEdit(Edu_Article edu_Article);
	
	public void click_numEdit(int article_id);
}
