package com.example.activitytransferdata.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class People implements Parcelable {

	private String name;
	private String sex;
	private int age;
	
	public People(Parcel in) {
		name = in.readString();
		sex = in.readString();
		age = in.readInt();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	/**
	 * –¥µΩ–Ú¡–ªØ
	 */
	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeString(name);
		out.writeString(sex);
		out.writeInt(age);
	}

	
	public static Creator<People> CREATOR = new Creator<People>() {
		
		@Override
		public People[] newArray(int size) {
			// TODO Auto-generated method stub
			return new People[size];
		}
		
		@Override
		public People createFromParcel(Parcel in) {
			// TODO Auto-generated method stub
			return new People(in);
		}
	};
	
	
	
}
