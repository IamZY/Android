package com.example.android_context;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView listView;
	private ArrayList<String> dataList = new ArrayList<String>();
	private ArrayAdapter<String> arrayAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.listView);
		// ע�������Ĳ˵�
		this.registerForContextMenu(listView);
		// ��ʼ������

		initData();

		arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				dataList);

		listView.setAdapter(arrayAdapter);

	}

	/**
	 * ���������Ĳˆ�
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		// �����˵�������
		MenuInflater menuInflater = getMenuInflater();
		// ���˵����òβ˵�ѡ��
		menuInflater.inflate(R.menu.list_menu, menu);
	}

	/**
	 * ��Ӧ�����Ĳ˵�
	 */
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// ��ȡlistView�������Ĳ˵�
		AdapterContextMenuInfo menuInfo = (AdapterContextMenuInfo) item.getMenuInfo();
		int position = menuInfo.position;

		switch (item.getItemId()) {
		case R.id.add:
			Toast.makeText(this, "add" + position, 0).show();
			break;
		case R.id.delete:
			Toast.makeText(this, "delete" + position, 0).show();
			dataList.remove(position);
			// ˢ������������
			arrayAdapter.notifyDataSetChanged();
			break;
		case R.id.share:
			Toast.makeText(this, "share" + position, 0).show();
			break;
		case R.id.more:
			Toast.makeText(this, "more" + position, 0).show();
			break;
		default:
			break;
		}
		return super.onContextItemSelected(item);
	}

	private void initData() {
		for (int i = 0; i < 30; i++) {
			dataList.add("���ǵ�" + i + "����");
		}
	}

}
