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
	 * ��ǰ��Ŀ����
	 */
	@Override
	public int getCount() {
		return news.size();
	}

	/**
	 * ��������ֵ������Ŀչʾ������
	 */
	@Override
	public Object getItem(int position) {
		return news.get(position);
	}

	/**
	 * ��ȡ��Ŀ��id
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * ��ȡ��ǰ��Ŀչʾ�Ĳ���Ч��
	 */
	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;

		ViewHolder viewHolder;
		if (convertView == null) {
			// �Լ�����
			convertView = View.inflate(context, R.layout.lv_item, null);
			viewHolder = new ViewHolder();
			// ���ҵ��Ŀؼ��ŵ�������
			viewHolder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
			viewHolder.iv_title = (TextView) convertView.findViewById(R.id.iv_title);
			viewHolder.iv_desc = (TextView) convertView.findViewById(R.id.iv_desc);
			// �󶨵�convertView
			convertView.setTag(viewHolder);
			
		} else {
			// ��ǰ�и��õ�view
			viewHolder = (ViewHolder) convertView.getTag();
			
		}
		
		viewHolder.iv_icon.setImageResource(news.get(position).getResId());
		viewHolder.iv_title.setText(news.get(position).getTitle());
		viewHolder.iv_desc.setText(news.get(position).getDes());
		
		return convertView;
	}

	class ViewHolder{
		// ����һ���ؼ�
		
		ImageView iv_icon;
		TextView iv_title;
		TextView iv_desc;
		
	}
	
	
}
