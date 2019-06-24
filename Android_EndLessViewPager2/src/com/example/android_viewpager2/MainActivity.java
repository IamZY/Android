package com.example.android_viewpager2;

import java.util.ArrayList;

import com.example.android_viewpager2.adapter.MyViewPagerAdapter;
import com.example.android_viewpager2.bean.News;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	private static final int First_PAGE = 1;
	private ArrayList<News> newsList = new ArrayList<News>();
	protected int currentPosition;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

		initData();

		// ��������������
		viewPager.setAdapter(new MyViewPagerAdapter(this, newsList));

		// ��ʼֵ���ڵ�λ��һ��ʼ����ĳ��λ��
		viewPager.setCurrentItem(First_PAGE);

		// ����viewPager �����¼�
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			// ѡ�е�һҳ
			@Override
			public void onPageSelected(int position) {
				if (position == newsList.size() - 1) {
					currentPosition = 1;
				} else if (position == 0) {
					currentPosition = newsList.size() - 2;
				} else {
					currentPosition = position;
				}
				
				// false ƽ�Ȼ���
				viewPager.setCurrentItem(currentPosition, false);
			}

			// ����������
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPiexls) {

			}

			// ����״̬�ı�ķ���
			@Override
			public void onPageScrollStateChanged(int state) {
				// ����Ǿ�ֹ״̬
				if (state == ViewPager.SCROLL_STATE_IDLE) {
					viewPager.setCurrentItem(currentPosition, false);
				}
			}
		});

	}

	private void initData() {

		newsList.add(new News("���ĸ�ͼƬ", R.drawable.p4));
		newsList.add(new News("��һ��ͼƬ", R.drawable.p1));
		newsList.add(new News("�ڶ���ͼƬ", R.drawable.p2));
		newsList.add(new News("������ͼƬ", R.drawable.p3));
		newsList.add(new News("���ĸ�ͼƬ", R.drawable.p4));
		newsList.add(new News("��һ��ͼƬ", R.drawable.p1));

	}
}
