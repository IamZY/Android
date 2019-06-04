package com.example.activitytransferdata;

import com.example.activitytransferdata.bean.Person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et_name;
	private EditText et_age;
	private EditText et_password;
	private RadioGroup rg_sex;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		initView();
	}

	private void initView() {
		et_name = (EditText) findViewById(R.id.et_name); 
		et_age = (EditText) findViewById(R.id.et_age);
		et_password = (EditText) findViewById(R.id.et_password);
		rg_sex = (RadioGroup) findViewById(R.id.rg_sex);
	}
	
	public void reg(View view) {
		
		String name = et_name.getText().toString().trim();
		int age = 0;
		String str_age = et_age.getText().toString().trim();
		if(!TextUtils.isEmpty(str_age)) {			
			age = Integer.parseInt(str_age);
		}
		
		
		String password = et_password.getText().toString().trim();
		String sex = null;
		int checkedRadioButtonId = rg_sex.getCheckedRadioButtonId();
		
		switch (checkedRadioButtonId) {
		case R.id.rb_man:
			sex = "男";
			break;
		case R.id.rb_woman:			
			sex = "女";
			break;
		default:
			break;
		}
		
		// 提交信息
		if(TextUtils.isEmpty(name) || TextUtils.isEmpty(age+"") || TextUtils.isEmpty(password) || TextUtils.isEmpty(sex)) {
			Toast.makeText(this, "请将信息填完整", 0);
			return;
		}
		
		// 将获取信息跳转界面
		Intent intent = new Intent(this,SuccessActivity.class);
		
		intent.putExtra("name", name);
		intent.putExtra("age", age);
		intent.putExtra("sex", sex);
		
//		intent.putExtra("person", new Person(name, sex, age));
//		intent.putExtra("people", new People(name, sex, age));
		
		startActivity(intent);
		
		
	}
	

}
