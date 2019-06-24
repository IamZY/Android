package com.example.baseadapter_refresh.adapter;

import java.util.ArrayList;

import com.example.baseadapter_refresh.R;
import com.example.baseadapter_refresh.bean.News;

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

	public NewsAdapter(ArrayList<News> news, Context context) {
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
		View view = null;

		ViewHolder viewHolder;
		if (convertView == null) {
			// 自己打气
			convertView = View.inflate(context, R.layout.lv_item, null);
			viewHolder = new ViewHolder();
			// 将找到的控件放到容器中
			viewHolder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
			viewHolder.iv_title = (TextView) convertView.findViewById(R.id.iv_title);
			viewHolder.iv_desc = (TextView) convertView.findViewById(R.id.iv_desc);
			// 绑定到convertView
			convertView.setTag(viewHolder);
			
		} else {
			// 当前有复用的view
			viewHolder = (ViewHolder) convertView.getTag();
			
		}
		
		viewHolder.iv_icon.setImageResource(news.get(position).getResId());
		viewHolder.iv_title.setText(news.get(position).getTitle());
		viewHolder.iv_desc.setText(news.get(position).getDes());
		
		return convertView;
	}

	class ViewHolder{
		// 定义一个控件
		
		ImageView iv_icon;
		TextView iv_title;
		TextView iv_desc;
		
	}
	
	
}
