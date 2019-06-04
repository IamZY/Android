package com.ntuzy.android_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	
	public void jump(View v) {
		// 指定要跳转的activity
		// 开启这个意图
		Intent intent = new Intent(this,MyFirstActivity.class);
		startActivity(intent);
		// 关闭自己
		finish();
	}
	
}
