package com.example.listview_arrayadapter;

import java.util.ArrayList;

import com.example.listview_arrayadapter.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ArrayList<String> dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView listView = (ListView) findViewById(R.id.listView);

		// ׼������
		initData();

		// չʾ����
		// resource ����
		// objecs ���ϻ�������
//		listView.setAdapter(new ArrayAdapter<String>(this, R.layout.lv_item, R.id.textView, dataList));

		
		listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,dataList));
		
	}

	private void initData() {

		dataList = new ArrayList<String>();

		for (int i = 0; i < 20; i++) {
			dataList.add("���ǵ�" + i + "��");
		}

	}

}
