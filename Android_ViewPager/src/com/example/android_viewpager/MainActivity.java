package com.example.android_viewpager;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	private ViewPager viewPager;
	private ArrayList<View> viewList = new ArrayList<View>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewPager = (ViewPager) findViewById(R.id.viewPager);

		//
		initView();

		viewPager.setAdapter(new MyPagerAdapter(viewList));
		
	}

	private void initView() {
		View v1 = View.inflate(this, R.layout.vp1, null);
		View v2 = View.inflate(this, R.layout.vp2, null);
		View v3 = View.inflate(this, R.layout.vp3, null);
		View v4 = View.inflate(this, R.layout.vp4, null);

		viewList.add(v1);
		viewList.add(v2);
		viewList.add(v3);
		viewList.add(v4);
	}

}
