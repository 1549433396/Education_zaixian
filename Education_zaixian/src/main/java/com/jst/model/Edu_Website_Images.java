package com.jst.model;

public class Edu_Website_Images {
  
	private int image_id;   // id
	private String image_url;//图片地址
	private String link_address;//图链接地址
	private String title;//图标题
	private Edu_Website_Images_Type type_id;//图片类型
	private int series_number;//序列号
	private String preview_url;//略缩图片地址
	private String color;//背景色
	private String describes;//图片描述
	private int shows;
	
	public int getShows() {
		return shows;
	}
	public void setShows(int shows) {
		this.shows = shows;
	}
	public int getImage_id() {
		return image_id;
	}
	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getLink_address() {
		return link_address;
	}
	public void setLink_address(String link_address) {
		this.link_address = link_address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSeries_number() {
		return series_number;
	}
	public void setSeries_number(int series_number) {
		this.series_number = series_number;
	}
	public String getPreview_url() {
		return preview_url;
	}
	public void setPreview_url(String preview_url) {
		this.preview_url = preview_url;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	public Edu_Website_Images_Type getType_id() {
		return type_id;
	}
	public void setType_id(Edu_Website_Images_Type type_id) {
		this.type_id = type_id;
	}
	@Override
	public String toString() {
		return "Edu_Website_Images [image_id=" + image_id + ", image_url=" + image_url + ", link_address="
				+ link_address + ", title=" + title + ", type_id=" + type_id + ", series_number=" + series_number
				+ ", preview_url=" + preview_url + ", color=" + color + ", describes=" + describes + "]";
	}
}
