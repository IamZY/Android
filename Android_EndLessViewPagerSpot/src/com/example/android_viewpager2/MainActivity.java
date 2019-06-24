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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {

	private static final int First_PAGE = 1;
	private ArrayList<News> newsList = new ArrayList<News>();
	protected int currentPosition;
	private LinearLayout ll_dots;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

		ll_dots = (LinearLayout) findViewById(R.id.ll_dots);

		initDots();

		initData();

		// 设置数据适配器
		viewPager.setAdapter(new MyViewPagerAdapter(this, newsList));

		// 初始值所在的位置一开始就在某个位置
		viewPager.setCurrentItem(First_PAGE);

		// 设置viewPager 监听事件
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			// 选中第一页
			@Override
			public void onPageSelected(int position) {
				if (position == newsList.size() - 1) {
					currentPosition = 1;
				} else if (position == 0) {
					currentPosition = newsList.size() - 2;
				} else {
					currentPosition = position;
				}

				int dotPosition = currentPosition;
				// 设置小点监听
				for (int i = 0; i < ll_dots.getChildCount(); i++) {
					ImageView view = (ImageView) ll_dots.getChildAt(i);
					if (i == dotPosition) {
						// 从线性布局中去除对应小店 设置点亮
						view.setImageResource(R.drawable.ic_launcher);
					} else {
						view.setImageResource(R.drawable.ic_launcher);
					}
				}
				// false 平稳滑动
				// viewPager.setCurrentItem(currentPosition, false);
			}

			// 滑动过程中
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPiexls) {

			}

			// 滑动状态改变的方法
			@Override
			public void onPageScrollStateChanged(int state) {
				// 如果是静止状态
				if (state == ViewPager.SCROLL_STATE_IDLE) {
					viewPager.setCurrentItem(currentPosition, false);
				}
			}
		});

	}

	private void initDots() {
		for (int i = 0; i < newsList.size() - 2; i++) {
			ImageView imageView = new ImageView(this);
			if (i == 0) {
				imageView.setImageResource(R.drawable.ic_launcher);
			} else {
				imageView.setImageResource(R.drawable.ic_launcher);
			}
			LayoutParams params = new LayoutParams(15, 15);
			params.setMargins(5, 5, 5, 5);

			ll_dots.addView(imageView, params);
		}
	}

	private void initData() {

		newsList.add(new News("第四个图片", R.drawable.p4));
		newsList.add(new News("第一个图片", R.drawable.p1));
		newsList.add(new News("第二个图片", R.drawable.p2));
		newsList.add(new News("第三个图片", R.drawable.p3));
		newsList.add(new News("第四个图片", R.drawable.p4));
		newsList.add(new News("第一个图片", R.drawable.p1));

	}
}
