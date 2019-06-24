package com.example.listview_baseadapter.adapter;

import java.util.ArrayList;

import com.example.listview_baseadapter.R;
import com.example.listview_sampleadapter.bean.News;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsAdapter extends BaseAdapter {

	private ArrayList<News> news;
	private Context context;
	
	
	public NewsAdapter(ArrayList<News> news,Context context) {
		this.news = news;
		this.context = context;
	}

	/**
	 * 当前条目个数
	 */
	@Override
	public int getCount() {
		return news.size();
	}

	/**
	 * 根据索引值返回条目展示的数据
	 */
	@Override
	public Object getItem(int position) {
		return news.get(position);
	}

	/**
	 * 获取条目的id
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * 获取当前条目展示的布局效果
	 */
	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 通过一个打起机讲布局
		
		// resource 布局文件
		// root 是否有挂在的父文件
		View view = View.inflate(context, R.layout.lv_item, null);
		
		// 找到控件
		TextView iv_title = (TextView) view.findViewById(R.id.iv_title);
		TextView iv_desc = (TextView) view.findViewById(R.id.iv_desc);
		ImageView iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
		
		
		iv_title.setText(news.get(position).getTitle());
		iv_desc.setText(news.get(position).getDes());
		iv_icon.setImageResource(news.get(position).getResId());
		
		return view;
	}

}
