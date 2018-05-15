package com.jst.model;

import java.io.Serializable;
import java.util.Date;

public class Edu_Article implements Serializable {
	private int article_id; //id 
	private String title;   //
	private String summary; //
	private String key_word;//
	private String image_url;//
	private String source;   //
	private String author;    //
	private Date create_time; //
	private Date  publish_time;//
	private String link;       //
	private int article_type;  //
	private int click_num;     //
	private int praise_count;  //
	private int comment_num;   //
	private int sort;          //
	private int releases;
	private Edu_Article_Content acontent;

	public int getReleases() {
		return releases;
	}

	public void setReleases(int releases) {
		this.releases = releases;
	}

	public Edu_Article_Content getAcontent() {
		return acontent;
	}

	public void setAcontent(Edu_Article_Content acontent) {
		this.acontent = acontent;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getKey_word() {
		return key_word;
	}

	public void setKey_word(String key_word) {
		this.key_word = key_word;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getArticle_type() {
		return article_type;
	}

	public void setArticle_type(int article_type) {
		this.article_type = article_type;
	}

	public int getClick_num() {
		return click_num;
	}

	public void setClick_num(int click_num) {
		this.click_num = click_num;
	}

	public int getPraise_count() {
		return praise_count;
	}

	public void setPraise_count(int praise_count) {
		this.praise_count = praise_count;
	}

	public int getComment_num() {
		return comment_num;
	}

	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
}
