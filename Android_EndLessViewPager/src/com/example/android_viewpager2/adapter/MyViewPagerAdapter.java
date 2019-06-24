package com.example.android_viewpager2.adapter;

import java.util.ArrayList;

import com.example.android_viewpager2.R;
import com.example.android_viewpager2.bean.News;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyViewPagerAdapter extends PagerAdapter {

	private Context context;
	private ArrayList<News> newsList;

	public MyViewPagerAdapter(Context context, ArrayList<News> newsList) {
		this.context = context;
		this.newsList = newsList;
	}

	/**
	 * 获取轮播图展示的总个数
	 */
	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		// TODO Auto-generated method stub
		return view == object;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		View vp_item = View.inflate(context, R.layout.vp_item, null);
		ImageView imageView = (ImageView) vp_item.findViewById(R.id.imageView);
		TextView textView = (TextView) vp_item.findViewById(R.id.tv_title);

		position = position % newsList.size();

		imageView.setImageResource(newsList.get(position).getResId());
		textView.setText(newsList.get(position).getTitle());

		container.addView(vp_item);

		return vp_item;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

}
