package com.jst.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class EduCourse extends EduTeacher {
    private Integer courseId;//�γ̱��
    private String courseName;//�γ�����
    private Integer isAvaliable;//�γ�״̬  1�����ϼ�  2�������¼�
    private Integer subjectId;//�γ�רҵid
    private String subjectLink;//�γ�רҵ��
    private Date addTime;//���ʱ��
    private BigDecimal sourcePrice;//�γ�ԭ��
    private BigDecimal currentPrice;//�γ����ۼ۸�ʵ��֧���۸�����Ϊ0�����ѹۿ�
    private String title;//�γ̼��
    private Integer lessionNum;//�ܿ�ʱ
    private String logo;//ͼƬ·��
    private Date updateTime;//������ʱ��
    private Integer pageBuycount;//��������
    private Integer pageViewcount;//�������
    private Date endTime;//��Ч����ʱ��
    private Integer losetype;//��Ч������ 0 ����ʱ��  1 ������
    private String loseTime;//��Ч�� ��Ʒ��������ʱ���
    private Integer sequence;//����
    private BigDecimal courseGrossIncome;//�ÿγ��ܹ����˶���Ǯ
    private String context; //�γ�����
    private SysSubject subject;
    //��ʦid
    private int id;
    //��ʦ����
    private String name;
    
    
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

	public SysSubject getSubject() {
		return subject;
	}

	public void setSubject(SysSubject subject) {
		this.subject = subject;
	}

	public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Integer getIsAvaliable() {
        return isAvaliable;
    }

    public void setIsAvaliable(Integer isAvaliable) {
        this.isAvaliable = isAvaliable;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectLink() {
        return subjectLink;
    }

    public void setSubjectLink(String subjectLink) {
        this.subjectLink = subjectLink == null ? null : subjectLink.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public BigDecimal getSourcePrice() {
        return sourcePrice;
    }

    public void setSourcePrice(BigDecimal sourcePrice) {
        this.sourcePrice = sourcePrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getLessionNum() {
        return lessionNum;
    }

    public void setLessionNum(Integer lessionNum) {
        this.lessionNum = lessionNum;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getPageBuycount() {
        return pageBuycount;
    }

    public void setPageBuycount(Integer pageBuycount) {
        this.pageBuycount = pageBuycount;
    }

    public Integer getPageViewcount() {
        return pageViewcount;
    }

    public void setPageViewcount(Integer pageViewcount) {
        this.pageViewcount = pageViewcount;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getLosetype() {
        return losetype;
    }

    public void setLosetype(Integer losetype) {
        this.losetype = losetype;
    }

    public String getLoseTime() {
        return loseTime;
    }

    public void setLoseTime(String loseTime) {
        this.loseTime = loseTime == null ? null : loseTime.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public BigDecimal getCourseGrossIncome() {
        return courseGrossIncome;
    }

    public void setCourseGrossIncome(BigDecimal courseGrossIncome) {
        this.courseGrossIncome = courseGrossIncome;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

	@Override
	public String toString() {
		return "EduCourse [courseId=" + courseId + ", courseName=" + courseName + ", isAvaliable=" + isAvaliable
				+ ", subjectId=" + subjectId + ", subjectLink=" + subjectLink + ", addTime=" + addTime
				+ ", sourcePrice=" + sourcePrice + ", currentPrice=" + currentPrice + ", title=" + title
				+ ", lessionNum=" + lessionNum + ", logo=" + logo + ", updateTime=" + updateTime + ", pageBuycount="
				+ pageBuycount + ", pageViewcount=" + pageViewcount + ", endTime=" + endTime + ", losetype=" + losetype
				+ ", loseTime=" + loseTime + ", sequence=" + sequence + ", courseGrossIncome=" + courseGrossIncome
				+ ", context=" + context + ", subject=" + subject + "]";
	}

    
    
}