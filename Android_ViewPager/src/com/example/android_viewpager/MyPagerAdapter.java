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
	 * ��ǰ����ͼ�Ƿ��instiateItem��Ӧ��view�Ƿ�һ��
	 */
	@Override
	public boolean isViewFromObject(View view, Object object) {
		// TODO Auto-generated method stub
		return view == object;
	}

	/**
	 * ������Ŀ
	 */
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
//		container.removeView(viewList.get(position));
		// ����Ŀ���Ƴ���ص���Ŀ
		container.removeView((View) object);
	}

	/**
	 * ʵ����view����ӵ�������
	 */
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// �Ӽ����и���������ȡ��ǰҪչʾ����ͼ
		View view = viewList.get(position);
		container.addView(view);
		return view;
	}

}
