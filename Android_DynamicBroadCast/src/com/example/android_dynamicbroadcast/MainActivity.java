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

		// ������ͼ������
		IntentFilter intentFilter = new IntentFilter();
		// �����Ļ�����Ķ���
		intentFilter.addAction("android.intent.action.SCREEN_OFF");
		// �����Ļ�����Ķ���
		intentFilter.addAction("android.intent.action.SCREEN_ON");
		// ע����Ļ����������Ч��
		registerReceiver(receiver, intentFilter);

	}

	class MyBroadCast extends BroadcastReceiver {
		// ������Ϣ
		@Override
		public void onReceive(Context context, Intent intent) {
			if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
				Log.i(TAG, "����");
			} else {
				Log.i(TAG, "����");
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
