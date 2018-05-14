package com.jst.model;

import java.util.Date;

public class EduCourseKpoint {
    private Integer kpointId;

    private Integer courseId;

    private String name;

    private Integer parentId;

    private Date addTime;

    private Integer sort;

    private Integer playCount;

    private Boolean isFree;

    private String videoUrl;

    private Integer teacherId;

    private String playTime;

    private Integer kpointType;

    private String videoType;

    private String fileType;

    private String content;

    public Integer getKpointId() {
        return kpointId;
    }

    public void setKpointId(Integer kpointId) {
        this.kpointId = kpointId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Integer playCount) {
        this.playCount = playCount;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime == null ? null : playTime.trim();
    }

    public Integer getKpointType() {
        return kpointType;
    }

    public void setKpointType(Integer kpointType) {
        this.kpointType = kpointType;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType == null ? null : videoType.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "EduCourseKpoint [kpointId=" + kpointId + ", courseId=" + courseId + ", name=" + name + ", parentId="
				+ parentId + ", addTime=" + addTime + ", sort=" + sort + ", playCount=" + playCount + ", isFree="
				+ isFree + ", videoUrl=" + videoUrl + ", teacherId=" + teacherId + ", playTime=" + playTime
				+ ", kpointType=" + kpointType + ", videoType=" + videoType + ", fileType=" + fileType + ", content="
				+ content + "]";
	}
    
    
}