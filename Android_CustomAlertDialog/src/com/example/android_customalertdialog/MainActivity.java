package com.example.android_customalertdialog;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		
	}
	
	
	public void regist(View view) {
		// 实例化builder对象
		Builder builder = new Builder(this);
		// 
		final AlertDialog create = builder.create();
		
		//
		View v = View.inflate(this, R.layout.dialog_regist, null);
		
		final EditText et_username = (EditText) v.findViewById(R.id.et_username);
		final EditText et_password = (EditText) v.findViewById(R.id.et_password);
		
		Button button = (Button) v.findViewById(R.id.submit);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String username = et_username.getText().toString().trim();
				String password = et_password.getText().toString().trim();
				
				Toast.makeText(MainActivity.this,username + password, 0).show();
				
				create.dismiss();
			}
		});
		
		
		create.setView(v);
		create.show();
		
	}

}
