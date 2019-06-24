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
	
		
		// ��listView������Ŀ���ʱ��
		listView.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				 Toast.makeText(MainActivity.this, position + "�������", 0);
				Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
				intent.putExtra("title", news.get(position).getTitle());
				intent.putExtra("des", news.get(position).getDes());
				startActivity(intent);
			}
		});
		
		
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {
			
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(MainActivity.this, position+"��������", 0).show();
				// true �������Ѹ��¼� false �����Ѹ��¼�  
				return true;
			}
		});
		
	}

	private void initData() {
		
		news = new ArrayList<News>();
		
		news.add(new News("����ǿ","��Ϣ����",R.drawable.ic_launcher));
		news.add(new News("����ǿ1","��Ϣ����r",R.drawable.ic_launcher));
		news.add(new News("����ǿ2","��Ϣ����rr",R.drawable.ic_launcher));
		news.add(new News("����ǿ3","��Ϣ����rrr",R.drawable.ic_launcher));
		news.add(new News("����ǿ4","��Ϣ����rrrr",R.drawable.ic_launcher));
		news.add(new News("����ǿ5","��Ϣ����rrrrr",R.drawable.ic_launcher));
		news.add(new News("����ǿ6","��Ϣ����rrrrrr",R.drawable.ic_launcher));
		news.add(new News("����ǿ7","��Ϣ����rrrrrr",R.drawable.ic_launcher));
		
	}

}
