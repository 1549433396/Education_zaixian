package com.jst.model;

import java.util.Date;

public class EduCourseNote {
	private Integer id;

	private Integer user_id;

	private Integer course_id;

	private Integer kpoint_id;

	private Date update_time;

	private Byte status;

	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}

	public Integer getKpoint_id() {
		return kpoint_id;
	}

	public void setKpoint_id(Integer kpoint_id) {
		this.kpoint_id = kpoint_id;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "EduCourseNote [id=" + id + ", user_id=" + user_id + ", course_id=" + course_id + ", kpoint_id="
				+ kpoint_id + ", update_time=" + update_time + ", status=" + status + ", content=" + content + "]";
	}
	
}