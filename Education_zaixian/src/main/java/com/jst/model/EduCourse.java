package com.jst.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class EduCourse extends EduTeacher {
    private Integer courseId;//课程编号
    private String courseName;//课程名称
    private Integer isAvaliable;//课程状态  1代表上架  2，代表下架
    private Integer subjectId;//课程专业id
    private String subjectLink;//课程专业链
    private Date addTime;//添加时间
    private BigDecimal sourcePrice;//课程原价
    private BigDecimal currentPrice;//课程销售价格，实际支付价格，设置为0则可免费观看
    private String title;//课程简介
    private Integer lessionNum;//总课时
    private String logo;//图片路径
    private Date updateTime;//最后更新时间
    private Integer pageBuycount;//销售数量
    private Integer pageViewcount;//浏览数量
    private Date endTime;//有效结束时间
    private Integer losetype;//有效期类型 0 到期时间  1 按天数
    private String loseTime;//有效期 商品订单过期时间点
    private Integer sequence;//序列
    private BigDecimal courseGrossIncome;//该课程总共卖了多少钱
    private String context; //课程详情
    private SysSubject subject;
    //讲师id
    private int id;
    //讲师名称
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