package com.example.android_listviewpopupwindow;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView listView;
	private ArrayList<String> arr = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.listView);

		initData();

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);

		listView.setAdapter(adapter);

		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

				// 获取当前位置 指的是宽和高
				int[] location = new int[2];
				view.getLocationInWindow(location);

				View v = View.inflate(MainActivity.this, R.layout.pop_item, null);
				
				
				final PopupWindow popupWindow = new PopupWindow(v, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				popupWindow.setOutsideTouchable(true);
				popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
				popupWindow.showAtLocation(parent, Gravity.TOP, location[0] + 5, (int)(location[1] - view.getHeight()*0.5f));
				TextView tv_copy = (TextView) v.findViewById(R.id.tv_copy);
				
				tv_copy.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						popupWindow.dismiss();
						Toast.makeText(MainActivity.this, "点了copy", 0).show();
					}
				});
				// 设置在外侧点击 消失
				return false;
			}
		});

	}

	private void initData() {
		for (int i = 0; i < 20; i++) {
			arr.add("这是第" + i + "条目");
		}
	}

}
