package com.example.android_viewpager2.bean;

public class News {

	private String title;
	private int resId;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	public News(String title, int resId) {
		super();
		this.title = title;
		this.resId = resId;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
