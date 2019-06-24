package com.example.android_dynamticfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		changeFragment(new LoginFragment(), "LoginFragment");

	}

	public void changeFragment(Fragment fragment, String tag) {
		FragmentManager supportFragmentManager = getSupportFragmentManager();
		FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
		beginTransaction.replace(R.id.framelayout, fragment, tag);
		beginTransaction.commit();
	}

}
