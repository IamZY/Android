package com.ntuzy.android_toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	
	public void clickMe(View v) 
	{
		// Context ������ Android���л���
		// duration ����ʱ��
		Toast.makeText(this, "���", Toast.LENGTH_LONG).show();
	}
	
	
}
