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
		// ͨ��һ�������������
		
		// resource �����ļ�
		// root �Ƿ��й��ڵĸ��ļ�
		View view = View.inflate(context, R.layout.lv_item, null);
		
		// �ҵ��ؼ�
		TextView iv_title = (TextView) view.findViewById(R.id.iv_title);
		TextView iv_desc = (TextView) view.findViewById(R.id.iv_desc);
		ImageView iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
		
		
		iv_title.setText(news.get(position).getTitle());
		iv_desc.setText(news.get(position).getDes());
		iv_icon.setImageResource(news.get(position).getResId());
		
		return view;
	}

}
