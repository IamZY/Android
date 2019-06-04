package com.example.futureactivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class MyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		Intent intent = getIntent();
		Uri data = intent.getData();
		
		Toast.makeText(this, data.toString(),Toast.LENGTH_SHORT).show();
		
	}
	
}
