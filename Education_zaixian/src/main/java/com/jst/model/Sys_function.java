package com.jst.model;

import java.util.Date;

/**
 * 这是一个权限表
 * @author Administrator
 *
 */
public class Sys_function {

	private int function_id;//权限id
	private int parent_id;//权限父id
	private String function_name;//权限名
	private String function_url;//权限url
	private int function_type;//权限类型 1，菜单 2，功能
	private Date create_time;//创建时间
	private int sort;//排序
	public int getFunction_id() {
		return function_id;
	}
	public void setFunction_id(int function_id) {
		this.function_id = function_id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getFunction_name() {
		return function_name;
	}
	public void setFunction_name(String function_name) {
		this.function_name = function_name;
	}
	public String getFunction_url() {
		return function_url;
	}
	public void setFunction_url(String function_url) {
		this.function_url = function_url;
	}
	public int getFunction_type() {
		return function_type;
	}
	public void setFunction_type(int function_type) {
		this.function_type = function_type;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "Sys_function [function_id=" + function_id + ", parent_id=" + parent_id + ", function_name="
				+ function_name + ", function_url=" + function_url + ", function_type=" + function_type
				+ ", create_time=" + create_time + ", sort=" + sort + "]";
	}
	
	
}
