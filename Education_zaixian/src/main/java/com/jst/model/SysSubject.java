package com.jst.model;

import java.util.Date;

/**
 * @author Administrator
 *רҵ��
 */
public class SysSubject {
	private int subjectId;//רҵid
	private String subjectName;//רҵ����
	private int status;//״̬ 0��Ĭ��  1,��ɾ��
	private Date createTime;//����ʱ��
	private int parentId;//��id
	private int sort;//�����ֶ�
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
