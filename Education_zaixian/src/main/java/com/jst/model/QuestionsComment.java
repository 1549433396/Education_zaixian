package com.jst.model;

import java.util.Date;

public class QuestionsComment {
	   private int id;// 主键id
	   private Edu_User eduUser; // 评论人id  对象edu_user表 拿EMAIL 邮箱号
	   private Questions questions;  // 问答id  对象  问答表edu_questions 拿TITLE  问答标题     
	   private String content;  // 评论内容
	   private int is_best; //是否最佳答案 0否1是;
	   private int reply_count; //回复数量
	   private int praise_count; //点赞
	   private Date add_time; //回复时间
	   private int comment_id;//父级评论
		private String start;
		private String end;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Edu_User getEduUser() {
		return eduUser;
	}
	public void setEduUser(Edu_User eduUser) {
		this.eduUser = eduUser;
	}
	public Questions getQuestions() {
		return questions;
	}
	public void setQuestions(Questions questions) {
		this.questions = questions;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIs_best() {
		return is_best;
	}
	public void setIs_best(int is_best) {
		this.is_best = is_best;
	}
	public int getReply_count() {
		return reply_count;
	}
	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}
	public int getPraise_count() {
		return praise_count;
	}
	public void setPraise_count(int praise_count) {
		this.praise_count = praise_count;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	
	
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "QuestionsComment [id=" + id + ", eduUser=" + eduUser + ", questions=" + questions + ", content="
				+ content + ", is_best=" + is_best + ", reply_count=" + reply_count + ", praise_count=" + praise_count
				+ ", add_time=" + add_time + ", comment_id=" + comment_id + "]";
	}
	
	   
}
