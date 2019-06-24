package com.example.android_asknetwork;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	protected static final int MSG_PIG = 0;

	private ImageView imageView;

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			
			if(msg.what == MSG_PIG) {
				// 获取消息内容 判断消息类型
				int picId = (Integer) msg.obj;
				imageView.setImageResource(picId);
			}
			
		}; 
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageView = (ImageView) findViewById(R.id.imageView);
		
	}
	

	// 只有主线程才能更新ui
	public void getPic(View v) {
		// 向网络请求图片
		
		new Thread() {
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 获取一个消息
				Message msg = Message.obtain();
				// 获取图片
//				imageView.setImageResource(R.drawable.ic_launcher);
				msg.obj = R.drawable.ic_launcher;
				// 定义消息类型
				msg.what = MSG_PIG;
				// 线程间通信
				handler.sendMessage(msg);
			};
		}.start();
		
		
	}
	
	
}
