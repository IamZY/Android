package com.example.android_dynamicbroadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	public static final String TAG = "MainActivity";
	private MyBroadCast receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		receiver = new MyBroadCast();

		// 创建意图过滤器
		IntentFilter intentFilter = new IntentFilter();
		// 添加屏幕锁屏的动作
		intentFilter.addAction("android.intent.action.SCREEN_OFF");
		// 添加屏幕开屏的动作
		intentFilter.addAction("android.intent.action.SCREEN_ON");
		// 注册屏幕锁屏开屏的效果
		registerReceiver(receiver, intentFilter);

	}

	class MyBroadCast extends BroadcastReceiver {
		// 接受信息
		@Override
		public void onReceive(Context context, Intent intent) {
			if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
				Log.i(TAG, "锁屏");
			} else {
				Log.i(TAG, "开屏");
			}
		}

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (receiver != null) {
			unregisterReceiver(receiver);
		}
	}

}
