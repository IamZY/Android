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
			mySelect = "ʯͷ";
			break;
		case R.id.radio1:
			mySelect = "����";
			break;
		case R.id.radio2:
			mySelect = "��";
			break;
		default:
			break;
		}
		
		
		// ��ȡϵͳѡ��
		Intent intent = new Intent(this,SystemActivity.class);
		// ������
		startActivityForResult(intent, 100);
		
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == 100 && resultCode == 101) 
		{
			String system_result = data.getStringExtra("result");
			
			if("ʯͷ".equals(mySelect) && "����".equals(system_result))
			{
				result = "ϵͳ�� "+system_result + "...����Ӯ";
			}else {
				result = "nb";
			}
			
		}
		
		tv_result.setText(result);
		
	}
	
	

}
