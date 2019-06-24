package com.example.android_notice;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Intent;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@SuppressLint("NewApi")
	public void sendNotice(View view) {
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		// 定义一个builder 通知的创建者
		Builder builder = new Builder(this);
		// 设置要跳转的intent
		Intent intent = new Intent(this, DetailsActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 100, intent, 0);
		// 设置标题
		Notification notification = builder.setContentTitle("xxxxxxxxx").setContentText("aaaaa")
				.setSmallIcon(R.drawable.ic_launcher)
				.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher)).setTicker("您有一条新消息")
				.setContentIntent(pendingIntent).setAutoCancel(true)
				//.setDefaults(Notification.DEFAULT_ALL)
				.build();

		notificationManager.notify("a", 1, notification);

	}

}
