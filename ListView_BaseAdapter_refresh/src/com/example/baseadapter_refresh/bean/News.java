package com.example.baseadapter_refresh.bean;

public class News {

	private String title;
	private String des;
	private int resId;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	public News(String title, String des, int resId) {
		super();
		this.title = title;
		this.des = des;
		this.resId = resId;
	}
	
	
	
	
	
}
