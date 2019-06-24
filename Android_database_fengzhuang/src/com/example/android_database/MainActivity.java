package com.example.android_database;

import java.util.ArrayList;

import com.example.android_database.bean.GirlFriend;
import com.example.android_database.dao.FriendDao;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView listView;
	private FriendDao friendDao;
	private ArrayList<GirlFriend> friendList;
	private ArrayAdapter<GirlFriend> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

		// 准备数据库
		// MySystemSqliteOpenHelper helper = new MySystemSqliteOpenHelper(this);
		// // 调用一个可读的数据库
		// helper.getReadableDatabase();

		friendDao = new FriendDao(this);

		friendList = friendDao.query();
		adapter = new ArrayAdapter<GirlFriend>(this, android.R.layout.simple_list_item_1, friendList);
		listView.setAdapter(adapter);

		// 设置条目点击事件,点击谁删除谁
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// 删除该条目
				friendDao.delete(friendList.get(position).getName());
				// 刷新界面
				notifyGirl();

			}
		});
		// 设置长按事件,当长按时,修改条目
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				// 修改成凤姐 18
				friendDao.update(friendList.get(position).getName(), "fengjie", 18);

				notifyGirl();
				return true;
			}

		});

	}

	private void initView() {
		listView = (ListView) findViewById(R.id.listView);
	}

	public void add(View view) {
		Builder builder = new Builder(this);

		final AlertDialog alertDialog = builder.create();

		View v = View.inflate(this, R.layout.add_dialog, null);
		// 找到弹框中的控件

		Button bt_sumbit = (Button) v.findViewById(R.id.bt_submit);

		final EditText et_name = (EditText) v.findViewById(R.id.et_name);
		final EditText et_age = (EditText) v.findViewById(R.id.et_age);
		alertDialog.setView(v);

		// 展示弹框
		alertDialog.show();

		bt_sumbit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 获取文本框信息
				String name = et_name.getText().toString().trim();
				String age = et_age.getText().toString().trim();
				// 将添加的信息,存到数据库中
				friendDao.insert(name, Integer.parseInt(age));
				// 弹框消失
				alertDialog.dismiss();
			}
		});

	}

	public void query(View view) {
		// 重新查询数据库
		notifyGirl();
		// girlAdapter = new ArrayAdapter<GirlFriend>(this,
		// android.R.layout.simple_list_item_1, friendList);
		// listView.setAdapter(girlAdapter);
		// ListView 刷新适配器
		// 1-集合数据发生改变
		// 2-集合还是那个集合
	}

	private void notifyGirl() {
		friendList = friendDao.query();
		// 适配器刷新方法
		adapter.notifyDataSetChanged();
	}

}
