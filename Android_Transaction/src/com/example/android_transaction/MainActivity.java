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
		// 转账
		SQLiteDatabase db = mySqliteOpenHelper.getWritableDatabase();
		// 开启一个事务
		try {
			db.beginTransaction();
			db.execSQL("update account set money = money - 500 where name =?", new String[] { "张三" });
			// 算数异常
			// int i = 1 / 0;
			db.execSQL("update account set money = money + 500 where name =?", new String[] { "李四" });
			// 设置一个成功标记
			db.setTransactionSuccessful();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 代码肯定会执行
			// 提交事务----判断当前是否有成功标记,如果有,提交,如果没有,回滚事务
			db.endTransaction();
		}
		db.close();
	}

	public void queryMoney(View v) {
		SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from account", null);
		while (cursor.moveToNext()) {
			// 先获取当前字段所在列的索引值,再获取当前索引值下的内容
			String name = cursor.getString(cursor.getColumnIndex("name"));
			int money = cursor.getInt(cursor.getColumnIndex("money"));
			Log.i(TAG, "name" + name + "---" + "money" + money);

		}
	}

}
