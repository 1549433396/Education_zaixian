package com.jst.model;

import java.util.Date;

public class EduComment {
	 private int comment_id; //评论表id
	 private Edu_User eduUser ;//用户id
	 private int p_comment_id; //父级评论id(为0则是一级评论,不为0则是回复)
	 private String content; //评论内容
	 private Date  addtime; //创建时间
	 private int other_id; //评论的相关id
	 private int praise_count; //点赞数量
	 private int perply_count;  //回复数量
	 private int type; //1文章 2课程
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public Edu_User getEduUser() {
		return eduUser;
	}
	public void setEduUser(Edu_User eduUser) {
		this.eduUser = eduUser;
	}
	public int getP_comment_id() {
		return p_comment_id;
	}
	public void setP_comment_id(int p_comment_id) {
		this.p_comment_id = p_comment_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public int getOther_id() {
		return other_id;
	}
	public void setOther_id(int other_id) {
		this.other_id = other_id;
	}
	public int getPraise_count() {
		return praise_count;
	}
	public void setPraise_count(int praise_count) {
		this.praise_count = praise_count;
	}
	public int getPerply_count() {
		return perply_count;
	}
	public void setPerply_count(int perply_count) {
		this.perply_count = perply_count;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "EduComment [comment_id=" + comment_id + ", eduUser=" + eduUser + ", p_comment_id=" + p_comment_id
				+ ", content=" + content + ", addtime=" + addtime + ", other_id=" + other_id + ", praise_count="
				+ praise_count + ", perply_count=" + perply_count + ", type=" + type + "]";
	}
	
	 
	 
	 
	 
}
