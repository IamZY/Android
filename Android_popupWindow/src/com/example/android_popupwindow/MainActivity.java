package com.example.android_popupwindow;

import org.apache.http.conn.BasicEofSensorWatcher;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void showPopup(View view) {

		View v = View.inflate(this, R.layout.pop_item, null);

		final PopupWindow popupWindow = new PopupWindow(v, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		// 在某个控件下面
		popupWindow.showAsDropDown(findViewById(R.id.btn), 0, 0);
		// 在外面可以点击 popup可以消失
		popupWindow.setOutsideTouchable(true);
		// 设置透明背景颜色
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

		TextView computer = (TextView) v.findViewById(R.id.computer);

		computer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "您选择了计算机", 0).show();
				popupWindow.dismiss();
			}
		});

	}
}
