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
		// ��ĳ���ؼ�����
		popupWindow.showAsDropDown(findViewById(R.id.btn), 0, 0);
		// ��������Ե�� popup������ʧ
		popupWindow.setOutsideTouchable(true);
		// ����͸��������ɫ
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

		TextView computer = (TextView) v.findViewById(R.id.computer);

		computer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "��ѡ���˼����", 0).show();
				popupWindow.dismiss();
			}
		});

	}
}
