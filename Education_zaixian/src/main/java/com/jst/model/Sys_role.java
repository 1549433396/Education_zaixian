package com.jst.model;

import java.util.Date;
import java.util.List;

public class Sys_role {
	
	private int role_id;//��ɫid
	private int function_id;//Ȩ��id
	private String role_name;//��ɫ��
	private Date create_time;//����ʱ��
	private List<Sys_function> list;//Ȩ�޵ļ���
	
	
	
	public int getFunction_id() {
		return function_id;
	}
	public void setFunction_id(int function_id) {
		this.function_id = function_id;
	}
	public List<Sys_function> getList() {
		return list;
	}
	public void setList(List<Sys_function> list) {
		this.list = list;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "sys_role [role_id=" + role_id + ", role_name=" + role_name + ", create_time=" + create_time + "]";
	}
	
	
	
}
