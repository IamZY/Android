package com.example.activityresultback;

import java.util.Random;

import android.R.array;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SystemActivity extends Activity {

	private String[] array = {"石头","剪刀","布"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_system);
		
		Random random = new Random();
		
		String result = array[random.nextInt(3)];
		
		// 设置回传结果
		// 
		Intent data = new Intent();
		data.putExtra("result", result);
		setResult(101, data);
		// 如果没有finish 结果不会回传
		finish();
		
	}

	
}
