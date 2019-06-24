package com.example.android_viewpager2.adapter;

import java.util.ArrayList;

import com.example.android_viewpager2.MainActivity;
import com.example.android_viewpager2.R;
import com.example.android_viewpager2.bean.News;

import android.content.Context;
import android.os.Handler;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.support.v4.view.PagerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyViewPagerAdapter extends PagerAdapter {

	private Context context;
	private ArrayList<News> newsList;
	private Handler handler;
	
	public MyViewPagerAdapter(Context context, ArrayList<News> newsList,Handler handler) {
		this.context = context;
		this.newsList = newsList;
		this.handler = handler;
	}

	/**
	 * 获取轮播图展示的总个数
	 */
	@Override
	public int getCount() {
		return newsList.size();
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

		imageView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					// 取消handler方法
					handler.removeCallbacksAndMessages(null);
					break;
					
				case MotionEvent.ACTION_UP:
				case MotionEvent.ACTION_CANCEL:
					// 取消handler方法
					handler.sendEmptyMessageDelayed(MainActivity.AUTO_SCROLL, 2000);
					break;
				default:
					break;
				}
				
				// true 消费该事件
				// false 不消费
				return true;
			}
		});
		
		TextView textView = (TextView) vp_item.findViewById(R.id.tv_title);

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
