package com.example.android_dymaticfragment;

import com.example.android_dymaticfragment.fragment.ContactFragment;
import com.example.android_dymaticfragment.fragment.DynamticFragment;
import com.example.android_dymaticfragment.fragment.MessageFragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;

@SuppressLint("Recycle")
public class MainActivity extends FragmentActivity implements OnClickListener {

	private FrameLayout frameLayout;
	private TextView tv_dymsg;
	private TextView tv_msg;
	private TextView tv_news;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

	}

	private void initView() {
		frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
		tv_dymsg = (TextView) findViewById(R.id.tv_dymsg);
		tv_msg = (TextView) findViewById(R.id.tv_msg);
		tv_news = (TextView) findViewById(R.id.tv_news);
		
		tv_dymsg.setOnClickListener(this);
		tv_msg.setOnClickListener(this);
		tv_news.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_dymsg:
			changeFragment(new DynamticFragment(),"DynamticFragment");
			break;
		case R.id.tv_msg:
			changeFragment(new MessageFragment(),"ContactFragment");
			break;
		case R.id.tv_news:
			changeFragment(new ContactFragment(),"ContactFragment");
			break;
		default:
			break;
		}
	}

	public void changeFragment(Fragment fragment,String tag) {
		FragmentManager supportFragmentManager = getSupportFragmentManager();
		FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
		beginTransaction.replace(R.id.frameLayout, fragment, tag);
		beginTransaction.commit();
	}
	
}
