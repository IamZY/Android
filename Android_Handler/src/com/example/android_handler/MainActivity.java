package com.example.android_handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final int KILL = 0;

	private TextView textView;

	private int time = 10;

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (time > 0) {
				time--;
				// textView 不可以赋值int类型
				textView.setText(time+"");
				// 当时间大于0继续发送消息
				handler.sendEmptyMessageDelayed(KILL, 1000);
			} else {
				textView.setText("start..");
			}

		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textView = (TextView) findViewById(R.id.textView);

	}

	public void startKill(View v) {
		// 延时时间
		handler.sendEmptyMessageDelayed(KILL, 1000);
	}

}
