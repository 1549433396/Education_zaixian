package com.jst.model;

import java.util.Date;
import java.util.List;

public class QuestionsTag {

	  private int questions_tag_id; //主键id
	  private String questions_tag_name; //标签名
	  private int status; //状态0默认1删除
	  private Date create_time; //创建时间
	  private int parent_id; //父级id
	  private List<Questions> listque;  //集合 问答表
	public int getQuestions_tag_id() {
		return questions_tag_id;
	}
	public void setQuestions_tag_id(int questions_tag_id) {
		this.questions_tag_id = questions_tag_id;
	}
	public String getQuestions_tag_name() {
		return questions_tag_name;
	}
	public void setQuestions_tag_name(String questions_tag_name) {
		this.questions_tag_name = questions_tag_name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public List<Questions> getListque() {
		return listque;
	}
	public void setListque(List<Questions> listque) {
		this.listque = listque;
	}
	@Override
	public String toString() {
		return "QuestionsTag [questions_tag_id=" + questions_tag_id + ", questions_tag_name=" + questions_tag_name
				+ ", status=" + status + ", create_time=" + create_time + ", parent_id=" + parent_id + ", listque="
				+ listque + "]";
	}
	
	  
	  
	
	
	  
}
