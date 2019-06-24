package com.example.activityresultback;

import android.app.Activity;
import android.content.Intent;
import android.database.CursorJoiner.Result;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

	private RadioGroup radioGroup;
	private TextView tv_result;
	private String mySelect = null;
	private String result = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

		tv_result = (TextView) findViewById(R.id.res);

	}

	public void vsSystem(View view) {
		int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
		switch (checkedRadioButtonId) {
		case R.id.radio0:
			mySelect = "石头";
			break;
		case R.id.radio1:
			mySelect = "剪刀";
			break;
		case R.id.radio2:
			mySelect = "布";
			break;
		default:
			break;
		}
		
		
		// 获取系统选择
		Intent intent = new Intent(this,SystemActivity.class);
		// 请求码
		startActivityForResult(intent, 100);
		
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == 100 && resultCode == 101) 
		{
			String system_result = data.getStringExtra("result");
			
			if("石头".equals(mySelect) && "剪刀".equals(system_result))
			{
				result = "系统出 "+system_result + "...我们赢";
			}else {
				result = "nb";
			}
			
		}
		
		tv_result.setText(result);
		
	}
	
	

}
