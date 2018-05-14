package com.jst.model;

import java.util.Date;

public class Sys_user {
	private int user_id;//主键
	private String login_name;//登录名
	private String login_pwd;//登录密码
	private String user_name;//用户真实姓名
	private int status;//状态，0 正常，1：冻结，2，删除
	private Date last_login_time;//最后登陆时间
	private String last_login_ip;//最后登录
	private Date create_time;//创建时间
	private String email;//邮箱地址
	private String tel;//手机号码
	private int role_id;//所属角色id
	private Sys_role sRole;//角色对象
	
	public Sys_role getsRole() {
		return sRole;
	}
	public void setsRole(Sys_role sRole) {
		this.sRole = sRole;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_pwd() {
		return login_pwd;
	}
	public void setLogin_pwd(String login_pwd) {
		this.login_pwd = login_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	public String getLast_login_ip() {
		return last_login_ip;
	}
	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	@Override
	public String toString() {
		return "Sys_user [user_id=" + user_id + ", login_name=" + login_name + ", login_pwd=" + login_pwd
				+ ", user_name=" + user_name + ", status=" + status + ", last_login_time=" + last_login_time
				+ ", last_login_ip=" + last_login_ip + ", create_time=" + create_time + ", email=" + email + ", tel="
				+ tel + ", role_id=" + role_id + "]";
	}
}
