package com.example.android_jingdong;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private RadioGroup radioGroup;
	private RadioButton rb_cart;
	private RadioButton rb_category;
	private RadioButton rb_home;
	private RadioButton rb_personal;
	private FragmentManager supportFragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

		supportFragmentManager = getSupportFragmentManager();
		// 默认 添加一个fragment
		addFragment(new Fragment1(), "fragment1");
	}

	private void initView() {
		radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
		rb_cart = (RadioButton) findViewById(R.id.rb_cart);
		rb_category = (RadioButton) findViewById(R.id.rb_category);
		rb_home = (RadioButton) findViewById(R.id.rb_home);
		rb_personal = (RadioButton) findViewById(R.id.rb_personal);

		rb_cart.setOnClickListener(this);
		rb_category.setOnClickListener(this);
		rb_home.setOnClickListener(this);
		rb_personal.setOnClickListener(this);

	}

	public void addFragment(Fragment fragment, String tag) {
		FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
		beginTransaction.add(R.id.framelayout, fragment, tag);
		// 添加到回退栈 并添加标记
		beginTransaction.addToBackStack(tag);
		beginTransaction.commit();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rb_home:
			addFragment(new Fragment1(), "fragment1");
			break;
		case R.id.rb_cart:
			addFragment(new Fragment2(), "fragment2");
			break;
		case R.id.rb_category:
			addFragment(new Fragment3(), "fragment3");
			break;
		case R.id.rb_personal:
			addFragment(new Fragment4(), "fragment4");
			break;
		default:
			break;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// 监听返回键
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// 获取当前回退栈中fragment的个数
			int backStackEntryCount = supportFragmentManager.getBackStackEntryCount();
			if (backStackEntryCount > 1) {
				while (supportFragmentManager.getBackStackEntryCount() > 1) {
					supportFragmentManager.popBackStackImmediate();
					rb_home.setChecked(true);
				}
			} else {
				finish();
			}
		}
		return true;
	}

}
