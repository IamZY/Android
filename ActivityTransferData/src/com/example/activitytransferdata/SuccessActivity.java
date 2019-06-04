package com.example.activitytransferdata;

import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;

import com.example.activitytransferdata.bean.People;
import com.example.activitytransferdata.bean.Person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SuccessActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_success);

		Intent intent = getIntent();

//		Person person = (Person) intent.getSerializableExtra("person");
//		People people = intent.getParcelableExtra("people");
		String name = intent.getStringExtra("name");
		String sex = intent.getStringExtra("sex");

		int age = intent.getIntExtra("age", -1);

		TextView tv_info = (TextView) findViewById(R.id.tv_info);

		tv_info.setText("name=" + name + ",age=" + age + "sex=" + sex);

	}

}
