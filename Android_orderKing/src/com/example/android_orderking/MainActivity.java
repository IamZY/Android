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
		// �����ߵ�Ȩ�� һ��Ϊnull
		// scheduler handler������
		// initialcode 0 ��ʼ��
		sendOrderedBroadcast(intent, null, resultReceiver, null, 0, "û���Ͻ�һ��", null);
	}
}
