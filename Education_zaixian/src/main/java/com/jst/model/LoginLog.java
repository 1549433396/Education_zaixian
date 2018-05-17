package com.jst.model;

import java.sql.Timestamp;
import java.util.Date;

public class LoginLog {
	private int log_id; //id
	private Date  login_time;  //登录时间
	private String  ip;  //登录IP
	private int  user_id;  //用户ID
	private String  os_name;  //操作系统
	private String user_agent; //浏览器
	private int num;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public Date getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}
	public void setLogin_time(Timestamp login_time) {
		this.login_time = login_time;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getOs_name() {
		return os_name;
	}
	public void setOs_name(String os_name) {
		this.os_name = os_name;
	}
	public String getUser_agent() {
		return user_agent;
	}
	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}
	@Override
	public String toString() {
		return "LoginLog [log_id=" + log_id + ", login_time=" + login_time + ", ip=" + ip + ", user_id=" + user_id
				+ ", os_name=" + os_name + ", user_agent=" + user_agent + "]";
	}
	
	
}
