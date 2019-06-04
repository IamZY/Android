package com.example.phonedemo;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText et_number;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et_number = (EditText) findViewById(R.id.et_number);
		
		
	}

	public void phoneCall(View view) {
		// ��ȡ�ֻ���
		String number = et_number.getText().toString().trim();
		// ������ͼ
		Intent intent = new Intent();
		// ������ͼ�Ķ���
		intent.setAction(Intent.ACTION_CALL);
		// ������ͼ����
		intent.setData(Uri.parse("tel:"+number));
		// �����
		startActivity(intent);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
