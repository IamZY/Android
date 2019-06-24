package com.example.android_sd;

import java.io.File;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MyBaseAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<File> fileArr;

	public MyBaseAdapter(Context context,ArrayList<File> fileArr) {
		this.context = context;
		this.fileArr = fileArr;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fileArr.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return fileArr.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView = new ImageView(context);
		String picPath = fileArr.get(position).getAbsolutePath();
		Bitmap decodeFile = BitmapFactory.decodeFile(picPath);
		imageView.setImageBitmap(decodeFile);
		return imageView;
	}

}
