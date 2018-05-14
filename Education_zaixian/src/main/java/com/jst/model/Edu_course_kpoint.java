package com.jst.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Edu_course_kpoint {
	
	private int kpoint_id;//主键
	private int course_id;//课程id
	private String name;//节点名称
	private int parent_id;//父id
	private Date add_time;//添加时间
	private int sort;//显示排序
	private int play_count;//播放次数
	private int is_free;//是否可以试听 1，免费2，收费
	private String video_url;//视频地址
	private int teacher_id;//讲师id
	private String play_time;//播放时间
	private int kpoint_type;//节点类型 0文件目录 1，视频
	private String video_type;//视频类型
	private String file_type;//文件类型
	private String content;//文本
	
	private List<Edu_course_kpoint> list = new ArrayList<>();
	
	
	
	public List<Edu_course_kpoint> getList() {
		return list;
	}
	public void setList(List<Edu_course_kpoint> list) {
		this.list = list;
	}
	public int getKpoint_id() {
		return kpoint_id;
	}
	public void setKpoint_id(int kpoint_id) {
		this.kpoint_id = kpoint_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getPlay_count() {
		return play_count;
	}
	public void setPlay_count(int play_count) {
		this.play_count = play_count;
	}
	public int getIs_free() {
		return is_free;
	}
	public void setIs_free(int is_free) {
		this.is_free = is_free;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getPlay_time() {
		return play_time;
	}
	public void setPlay_time(String play_time) {
		this.play_time = play_time;
	}
	public int getKpoint_type() {
		return kpoint_type;
	}
	public void setKpoint_type(int kpoint_type) {
		this.kpoint_type = kpoint_type;
	}
	public String getVideo_type() {
		return video_type;
	}
	public void setVideo_type(String video_type) {
		this.video_type = video_type;
	}
	public String getFile_type() {
		return file_type;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Edu_course_kpoint [kpoint_id=" + kpoint_id + ", course_id=" + course_id + ", name=" + name
				+ ", parent_id=" + parent_id + ", add_time=" + add_time + ", sort=" + sort + ", play_count="
				+ play_count + ", is_free=" + is_free + ", video_url=" + video_url + ", teacher_id=" + teacher_id
				+ ", play_time=" + play_time + ", kpoint_type=" + kpoint_type + ", video_type=" + video_type
				+ ", file_type=" + file_type + ", content=" + content + "]";
	}

}
