package com.example.android_viewpager2;

import java.util.ArrayList;

import com.example.android_viewpager2.adapter.MyViewPagerAdapter;
import com.example.android_viewpager2.bean.News;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	private ArrayList<News> newsList = new ArrayList<News>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

		initData();
		
		// ��������������
		viewPager.setAdapter(new MyViewPagerAdapter(this, newsList));
		
	}

	private void initData() {

		newsList.add(new News("��һ��ͼƬ", R.drawable.p1));
		newsList.add(new News("�ڶ���ͼƬ", R.drawable.p2));
		newsList.add(new News("������ͼƬ", R.drawable.p3));
		newsList.add(new News("���ĸ�ͼƬ", R.drawable.p4));

	}
}
