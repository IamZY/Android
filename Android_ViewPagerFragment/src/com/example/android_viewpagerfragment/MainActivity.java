package com.example.android_viewpagerfragment;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private ViewPager viewPager;
	private TextView tv_current;
	private TextView tv_future;

	ArrayList<TextView> viewList = new ArrayList<TextView>();

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

		viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

			private Fragment fragment;

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 2;
			}

			/**
			 * 根据索引值获取对应的fragment
			 */
			@Override
			public Fragment getItem(int position) {
				if (position == 0) {
					fragment = new CurrentFragment();
				} else {
					fragment = new FutureFragment();
				}
				return fragment;
			}
		});

		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				for (int i = 0; i < viewList.size(); i++) {
					TextView now = viewList.get(i);
					if (position == i) {
						now.setTextColor(Color.RED);
					} else {
						now.setTextColor(Color.BLACK);
					}
				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void initView() {
		viewPager = (ViewPager) findViewById(R.id.viewPager);

		tv_current = (TextView) findViewById(R.id.tv_current);
		tv_future = (TextView) findViewById(R.id.tv_future);

		viewList.add(tv_current);
		viewList.add(tv_future);

		for (int i = 0; i < viewList.size(); i++) {
			viewList.get(i).setOnClickListener(this);
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_current:
			viewPager.setCurrentItem(0);
			break;
		case R.id.tv_future:
			viewPager.setCurrentItem(1);
			break;
		default:
			break;
		}
	}

}
