package com.example.android_transaction;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";
	private MySqliteOpenHelper mySqliteOpenHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mySqliteOpenHelper = new MySqliteOpenHelper(this);
	}

	public void transMoney(View v) {
		// ת��
		SQLiteDatabase db = mySqliteOpenHelper.getWritableDatabase();
		// ����һ������
		try {
			db.beginTransaction();
			db.execSQL("update account set money = money - 500 where name =?", new String[] { "����" });
			// �����쳣
			// int i = 1 / 0;
			db.execSQL("update account set money = money + 500 where name =?", new String[] { "����" });
			// ����һ���ɹ����
			db.setTransactionSuccessful();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ����϶���ִ��
			// �ύ����----�жϵ�ǰ�Ƿ��гɹ����,�����,�ύ,���û��,�ع�����
			db.endTransaction();
		}
		db.close();
	}

	public void queryMoney(View v) {
		SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from account", null);
		while (cursor.moveToNext()) {
			// �Ȼ�ȡ��ǰ�ֶ������е�����ֵ,�ٻ�ȡ��ǰ����ֵ�µ�����
			String name = cursor.getString(cursor.getColumnIndex("name"));
			int money = cursor.getInt(cursor.getColumnIndex("money"));
			Log.i(TAG, "name" + name + "---" + "money" + money);

		}
	}

}
