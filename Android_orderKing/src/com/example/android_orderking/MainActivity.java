package com.example.android_orderking;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private BroadcastReceiver resultReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			Toast.makeText(MainActivity.this, getResultData(), Toast.LENGTH_SHORT).show();
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void send(View v) {
		Intent intent = new Intent();
		intent.setAction("com.example.liangshi");
		// 接收者的权限 一般为null
		// scheduler handler处理器
		// initialcode 0 初始吗
		sendOrderedBroadcast(intent, null, resultReceiver, null, 0, "没人上交一旦", null);
	}
}
