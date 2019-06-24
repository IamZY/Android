package com.example.listview_sampleadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView listView = (ListView) findViewById(R.id.listView);

		String[] from = { "title", "des", "resId" };
		int[] to = { R.id.iv_title, R.id.iv_desc, R.id.iv_icon };
		listView.setAdapter(new SimpleAdapter(this, getData(), R.layout.lv_item, from, to));
	}

	private List<? extends Map<String, ?>> getData() {

		List<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> mapData = new HashMap<String, Object>();

		// 往map中放数据
		mapData.put("title", "我是第一条数据");
		mapData.put("des", "这一条数据中包含很多信息");
		mapData.put("resId", R.drawable.ic_launcher);

		// 将map存放到list中
		dataList.add(mapData);

		mapData = new HashMap<String, Object>();
		mapData.put("title", "我是第二条数据");
		mapData.put("des", "这一条数据中包含很多信息");
		mapData.put("resId", R.drawable.ic_launcher);
		dataList.add(mapData);

		mapData = new HashMap<String, Object>();
		mapData.put("title", "我是第三条数据");
		mapData.put("des", "这一条数据中包含很多信息");
		mapData.put("resId", R.drawable.ic_launcher);
		dataList.add(mapData);

		mapData = new HashMap<String, Object>();
		mapData.put("title", "我是第四条数据");
		mapData.put("des", "这一条数据中包含很多信息");
		mapData.put("resId", R.drawable.ic_launcher);
		dataList.add(mapData);

		mapData = new HashMap<String, Object>();
		mapData.put("title", "我是第五条数据");
		mapData.put("des", "这一条数据中包含很多信息");
		mapData.put("resId", R.drawable.ic_launcher);
		dataList.add(mapData);

		return dataList;
	}

}
