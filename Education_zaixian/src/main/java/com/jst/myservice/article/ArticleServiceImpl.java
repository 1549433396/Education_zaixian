package com.jst.myservice.article;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.article.ArticleMapper;
import com.jst.model.EduComment;
import com.jst.model.Edu_Article;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;

	public void edit(Edu_Article map) {
		articleMapper.edit(map);
		updateContent(map);
	}

	public List<Edu_Article> listAll(Map map) {
		List<Edu_Article>listAll=articleMapper.listAll(map);
		return listAll;
	}

	public void save(Edu_Article map) {
		articleMapper.save(map);
	}

	public void delete(int article_id) {
		articleMapper.delete(article_id);
	}

	public Edu_Article getById(int article_id) {
		Edu_Article article=articleMapper.getById(article_id);
		return article;
	}

	@Override
	public void addContent(Edu_Article map) {
		articleMapper.addContent(map);

	}

	@Override
	public void updateContent(Edu_Article map) {
		articleMapper.updateContent(map);
	}

	@Override
	public void deleteAll(Integer[] chk_value) {
		articleMapper.deleteAll(chk_value);
	}

	@Override
	public List<Edu_Article> alistAll() {
		List<Edu_Article>list=articleMapper.alistAll();
		return list;
	}

	@Override
	public void releaseEdit(Edu_Article edu_Article) {
		articleMapper.releaseEdit(edu_Article);
	}

	@Override
	public void click_numEdit(int article_id) {
		articleMapper.click_numEdit(article_id);
	}

	@Override
	public void editCommentNum(int article_id) {
		articleMapper.editCommentNum(article_id);
	}

	@Override
	public void editPraise(int article_id) {
		articleMapper.editPraise(article_id);
	}
}
