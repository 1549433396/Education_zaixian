package com.jst.model;

import java.util.Date;

public class EduTeacher {
	public int id;//��ʦid;
	public String name;//��ʦ����
	public String th_name;//��ʦ�˺�
	public String th_pw;//��ʦ����
	public String education;//��ʦ������һ�仰˵����ʦ
	public String career;//��ʦ���
	public int is_star;//ͷ�� 1���߼���ʦ  2����ϯ��ʦ
	public String pic_path;//ͼƬ·��
	public int status;//״̬ 0��������1��ɾ��
	public Date create_time;//����ʱ��
	public Date updata_time;//����ʱ��
	public int subject_id;//רҵid
	public int sort;//����
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
