package com.example.listview_baseadapter;

import java.util.ArrayList;

import com.example.listview_baseadapter.adapter.NewsAdapter;
import com.example.listview_sampleadapter.bean.News;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView listView;
	private ArrayList<News> news;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView = (ListView) findViewById(R.id.listView);
		
		
		initData();
		
		listView.setAdapter(new NewsAdapter(news,this));
	
		
		// 对listView设置条目点击时间
		listView.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				 Toast.makeText(MainActivity.this, position + "被点击了", 0);
				Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
				intent.putExtra("title", news.get(position).getTitle());
				intent.putExtra("des", news.get(position).getDes());
				startActivity(intent);
			}
		});
		
		
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {
			
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(MainActivity.this, position+"被长按了", 0).show();
				// true 代表消费该事件 false 不消费该事件  
				return true;
			}
		});
		
	}

	private void initData() {
		
		news = new ArrayList<News>();
		
		news.add(new News("王宝强","信息量大",R.drawable.ic_launcher));
		news.add(new News("王宝强1","信息量大r",R.drawable.ic_launcher));
		news.add(new News("王宝强2","信息量大rr",R.drawable.ic_launcher));
		news.add(new News("王宝强3","信息量大rrr",R.drawable.ic_launcher));
		news.add(new News("王宝强4","信息量大rrrr",R.drawable.ic_launcher));
		news.add(new News("王宝强5","信息量大rrrrr",R.drawable.ic_launcher));
		news.add(new News("王宝强6","信息量大rrrrrr",R.drawable.ic_launcher));
		news.add(new News("王宝强7","信息量大rrrrrr",R.drawable.ic_launcher));
		
	}

}
