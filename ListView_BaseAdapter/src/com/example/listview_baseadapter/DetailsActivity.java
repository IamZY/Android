package com.example.listview_baseadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class DetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		
		Intent intent = getIntent();
		String title = intent.getStringExtra("title");
		String des = intent.getStringExtra("des");
		Toast.makeText(this, title + "::" + des, 0).show();
		
	}

	
}
