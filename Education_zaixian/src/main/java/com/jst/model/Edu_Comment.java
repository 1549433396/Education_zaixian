package com.jst.model;

import java.util.Date;


public class Edu_Comment {

	private int comment_id;         //评论id
    private Edu_User userId;        //用户外键id
    private int p_comment_id;       //父级评论id
    private String content;         //评论内容
    private Date addtime;           //创建时间
    private int other_id;           //评论相关id
    private int praise_count;       //点赞数量
    private int reply_count;        //回复数量
    private int type;               //1文章，2课程
    
    @Override
	public String toString() {
		return "Edu_Comment [comment_id=" + comment_id + ", userId=" + userId + ", p_comment_id=" + p_comment_id
				+ ", content=" + content + ", addtime=" + addtime + ", other_id=" + other_id + ", praise_count="
				+ praise_count + ", reply_count=" + reply_count + ", type=" + type + "]";
	}
	public Edu_User getUserId() {
		return userId;
	}
	public void setUserId(Edu_User userId) {
		this.userId = userId;
	}

	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
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
	public int getReply_count() {
		return reply_count;
	}
	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
    
	
}
