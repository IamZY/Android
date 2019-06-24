package com.example.gridview_arrayadapter;

import java.util.ArrayList;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ArrayList<String> dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		GridView gridView = (GridView) findViewById(R.id.gridView);

		// 准备数据
		initData();

		// 展示数组
		// resource 布局
		// objecs 集合或者数组
//		listView.setAdapter(new ArrayAdapter<String>(this, R.layout.lv_item, R.id.textView, dataList));

		
		gridView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,dataList));
		
	}

	private void initData() {

		dataList = new ArrayList<String>();

		for (int i = 0; i < 20; i++) {
			dataList.add("我是第" + i + "条");
		}

	}

}
