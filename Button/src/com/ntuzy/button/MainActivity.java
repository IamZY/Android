package com.ntuzy.button;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {  //第三种 implements OnClickListener {

	private ImageView view;

	/**
	 * Activity 一创建就调用的方法 Java main
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置相关联的布局
		setContentView(R.layout.activity_main);
		// 多态
		Button btClick = (Button) findViewById(R.id.bt_click);
		
		view = (ImageView) findViewById(R.id.iv_pic);
		
		// 对按钮注册监听器
		// 第一种 匿名内部类
//		btClick.setOnClickListener(new OnClickListener() {
//			
//			// 当点击按钮 手指抬起时
//			@Override
//			public void onClick(View v) {
//				view.setImageResource(R.drawable.ah);
//			}
//		});
		
		// 第二种
//		btClick.setOnClickListener(new MyClickListener());
		
		// 第三种
//		btClick.setOnClickListener(this);
		
	}
	
	// 第四种
	public void showPic(View v) {
		view.setImageResource(R.drawable.ah);
	}

	/**
	 * 内部类
	 * @author IamZY
	 *
	 */
	class MyClickListener implements OnClickListener
	{
		@Override
		public void onClick(View v) {
			view.setImageResource(R.drawable.ah);
		}
	}

	/**
	 * 第三种
	 */
//	@Override
//	public void onClick(View v) {
//		switch (v.getId()) {
//		case R.id.bt_click:
//			view.setImageResource(R.drawable.ah);
//			break;
//
//		default:
//			break;
//		}
//	}
	

	
}





