package com.jst.model;

import java.util.Date;
import java.util.List;

public class Teacher {

	private int id;//教师ID
	private String name;//教师名称
	private String th_name;//老师账号
	private String th_pw;//老师密码
	private String education;//教师资历,一句话说明老师
	private String career;//教师简介
	private int is_star;//头衔 1高级讲师2首席讲师
	private String pic_path;//图片路径
	private int status;//状态:0正常1删除
	private Date create_time;//创建时间
	private Date update_time;//更新时间
	private Subject subject_id;//专业ID
	private int sort;//排序
	List<Course> courses; 
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTh_name() {
		return th_name;
	}
	public void setTh_name(String th_name) {
		this.th_name = th_name;
	}
	public String getTh_pw() {
		return th_pw;
	}
	public void setTh_pw(String th_pw) {
		this.th_pw = th_pw;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public int getIs_star() {
		return is_star;
	}
	public void setIs_star(int is_star) {
		this.is_star = is_star;
	}
	public String getPic_path() {
		return pic_path;
	}
	public void setPic_path(String pic_path) {
		this.pic_path = pic_path;
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
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Subject getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(Subject subject_id) {
		this.subject_id = subject_id;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", th_name=" + th_name + ", th_pw=" + th_pw + ", education="
				+ education + ", career=" + career + ", is_star=" + is_star + ", pic_path=" + pic_path + ", status="
				+ status + ", create_time=" + create_time + ", update_time=" + update_time + ", subject_id="
				+ subject_id + ", sort=" + sort + "]";
	}
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	public Teacher(String name, String th_name, String th_pw, String education, String career, int is_star,
			String pic_path, int status, Date create_time, Date update_time, Subject subject_id, int sort) {
		super();
		this.name = name;
		this.th_name = th_name;
		this.th_pw = th_pw;
		this.education = education;
		this.career = career;
		this.is_star = is_star;
		this.pic_path = pic_path;
		this.status = status;
		this.create_time = create_time;
		this.update_time = update_time;
		this.subject_id = subject_id;
		this.sort = sort;
	}
	
}
