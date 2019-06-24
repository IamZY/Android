package com.example.android_activityfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.style.URLSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends FragmentActivity {

	String[] urls = new String[] { "www.aaa.com", "www.bbb.com", "www.ccc.com", "www.eee.com" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

		viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return urls.length;
			}

			@Override
			public Fragment getItem(int arg0) {
				// ´´½¨fragment
//				NewsFragment newsFragment = new NewsFragment(urls[arg0]);
				Fragment fragment = NewsFragment.getInstance(urls[arg0]);
				return fragment;
			}
		});

	}

}
