package com.jst.model;

import java.util.Date;

/**
 * @author Administrator
 *专业表
 */
public class SysSubject {
	private int subjectId;//专业id
	private String subjectName;//专业名称
	private int status;//状态 0：默认  1,：删除
	private Date createTime;//创建时间
	private int parentId;//父id
	private int sort;//排序字段
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "SysSubject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", status=" + status
				+ ", createTime=" + createTime + ", parentId=" + parentId + ", sort=" + sort + "]";
	}
	
	
}
