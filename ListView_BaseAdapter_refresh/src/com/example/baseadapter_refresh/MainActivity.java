package com.example.baseadapter_refresh;

import java.util.ArrayList;

import com.example.baseadapter_refresh.adapter.NewsAdapter;
import com.example.baseadapter_refresh.bean.News;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listView;
	private ArrayList<News> news;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.listView);

		initData();

		listView.setAdapter(new NewsAdapter(news, this));

	}

	private void initData() {

		news = new ArrayList<News>();

		for (int i = 0; i < 100000; i++) {
			news.add(new News("王宝强", "信息量大" + i, R.drawable.ic_launcher));
		}

	}

}
