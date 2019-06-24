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

		// ׼�����ݿ�
		// MySystemSqliteOpenHelper helper = new MySystemSqliteOpenHelper(this);
		// // ����һ���ɶ������ݿ�
		// helper.getReadableDatabase();

		friendDao = new FriendDao(this);

		friendList = friendDao.query();
		adapter = new ArrayAdapter<GirlFriend>(this, android.R.layout.simple_list_item_1, friendList);
		listView.setAdapter(adapter);

		// ������Ŀ����¼�,���˭ɾ��˭
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// ɾ������Ŀ
				friendDao.delete(friendList.get(position).getName());
				// ˢ�½���
				notifyGirl();

			}
		});
		// ���ó����¼�,������ʱ,�޸���Ŀ
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				// �޸ĳɷ�� 18
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
		// �ҵ������еĿؼ�

		Button bt_sumbit = (Button) v.findViewById(R.id.bt_submit);

		final EditText et_name = (EditText) v.findViewById(R.id.et_name);
		final EditText et_age = (EditText) v.findViewById(R.id.et_age);
		alertDialog.setView(v);

		// չʾ����
		alertDialog.show();

		bt_sumbit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ��ȡ�ı�����Ϣ
				String name = et_name.getText().toString().trim();
				String age = et_age.getText().toString().trim();
				// ����ӵ���Ϣ,�浽���ݿ���
				friendDao.insert(name, Integer.parseInt(age));
				// ������ʧ
				alertDialog.dismiss();
			}
		});

	}

	public void query(View view) {
		// ���²�ѯ���ݿ�
		notifyGirl();
		// girlAdapter = new ArrayAdapter<GirlFriend>(this,
		// android.R.layout.simple_list_item_1, friendList);
		// listView.setAdapter(girlAdapter);
		// ListView ˢ��������
		// 1-�������ݷ����ı�
		// 2-���ϻ����Ǹ�����
	}

	private void notifyGirl() {
		friendList = friendDao.query();
		// ������ˢ�·���
		adapter.notifyDataSetChanged();
	}

}
