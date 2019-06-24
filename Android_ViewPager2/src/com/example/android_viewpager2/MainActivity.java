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
		
		// 设置数据适配器
		viewPager.setAdapter(new MyViewPagerAdapter(this, newsList));
		
	}

	private void initData() {

		newsList.add(new News("第一个图片", R.drawable.p1));
		newsList.add(new News("第二个图片", R.drawable.p2));
		newsList.add(new News("第三个图片", R.drawable.p3));
		newsList.add(new News("第四个图片", R.drawable.p4));

	}
}
