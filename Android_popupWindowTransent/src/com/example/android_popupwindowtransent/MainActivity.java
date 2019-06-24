package com.example.android_popupwindowtransent;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void showPop(View view) {

		PopupWindow popupWindow = new PopupWindow();
		View contentView = View.inflate(this, R.layout.pop_item, null);
		popupWindow.setContentView(contentView);
		// 设置宽高
		popupWindow.setWidth(LayoutParams.WRAP_CONTENT);
		popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
		// 可以获取焦点
		popupWindow.setFocusable(true);

		// 展示popWindow
		popupWindow.showAtLocation(findViewById(R.id.btn), Gravity.TOP | Gravity.RIGHT, 0, 0);
	}

}
