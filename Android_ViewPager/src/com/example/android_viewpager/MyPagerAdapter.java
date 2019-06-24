package com.example.android_viewpager;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAdapter extends PagerAdapter {

	private ArrayList<View> viewList;

	public MyPagerAdapter(ArrayList<View> viewList) {
		this.viewList = viewList;
	}

	@Override
	public int getCount() {
		return viewList.size();
	}

	/**
	 * 当前的视图是否和instiateItem对应的view是否一致
	 */
	@Override
	public boolean isViewFromObject(View view, Object object) {
		// TODO Auto-generated method stub
		return view == object;
	}

	/**
	 * 销毁条目
	 */
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
//		container.removeView(viewList.get(position));
		// 从条目中移除相关的条目
		container.removeView((View) object);
	}

	/**
	 * 实例化view并添加到容器中
	 */
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// 从集合中根据索引获取当前要展示的视图
		View view = viewList.get(position);
		container.addView(view);
		return view;
	}

}
