package com.jst.model;

import java.util.Date;

public class EduTeacher {
	public int id;//教师id;
	public String name;//教师名称
	public String th_name;//教师账号
	public String th_pw;//教师密码
	public String education;//教师资历，一句话说明老师
	public String career;//教师简介
	public int is_star;//头衔 1，高级讲师  2，首席讲师
	public String pic_path;//图片路径
	public int status;//状态 0，正常，1，删除
	public Date create_time;//创建时间
	public Date updata_time;//更新时间
	public int subject_id;//专业id
	public int sort;//排序
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
	public Date getUpdata_time() {
		return updata_time;
	}
	public void setUpdata_time(Date updata_time) {
		this.updata_time = updata_time;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
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
		return "EduTeacher [id=" + id + ", name=" + name + ", th_name=" + th_name + ", th_pw=" + th_pw + ", education="
				+ education + ", career=" + career + ", is_star=" + is_star + ", pic_path=" + pic_path + ", status="
				+ status + ", create_time=" + create_time + ", updata_time=" + updata_time + ", subject_id="
				+ subject_id + ", sort=" + sort + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getTh_name()=" + getTh_name() + ", getTh_pw()=" + getTh_pw() + ", getEducation()=" + getEducation()
				+ ", getCareer()=" + getCareer() + ", getIs_star()=" + getIs_star() + ", getPic_path()=" + getPic_path()
				+ ", getStatus()=" + getStatus() + ", getCreate_time()=" + getCreate_time() + ", getUpdata_time()="
				+ getUpdata_time() + ", getSubject_id()=" + getSubject_id() + ", getSort()=" + getSort()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
