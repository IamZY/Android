package com.example.activitystart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void startMain(View view) {
		Intent intent = new Intent(this,MainActivity.class);
		startActivity(intent);
	}
	
	public void startSecond(View view) {
		Intent intent = new Intent(this,SecondActivity.class);
		startActivity(intent);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "MainActivity---"+this.toString() + this.getTaskId());
	}
	
	
}
