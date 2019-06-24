package com.example.android_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySystemSqliteOpenHelper extends SQLiteOpenHelper {

	private static final String TAG = "MySystemSqliteOpenHelper";

	/**
	 * 
	 * @param context
	 *            上下文
	 * @param name
	 *            数据库名称
	 * @param factory
	 *            游标工厂 null
	 * @param version
	 *            版本号
	 */
	public MySystemSqliteOpenHelper(Context context) {
		super(context, "text.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 数据库创建运行的方法 只会被执行一次
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table girlfriend " + "(_id integer primary key autoincrement,"
				+ "name varchar(20),age integer)");
	}

	/**
	 * 数据路更新的方法
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// 1 _id name age
		// 2 -id name age size
		// 3 _id name age address
		Log.i(TAG, "onUpgrade");
		switch (oldVersion) {
		case 1:
			// 版本一升级成版本2 需要添加一列
			db.execSQL("alter table girlfriend add size integer");
			// break;
		case 2:
			// 版本二升级成版本3 再添加一列
			db.execSQL("alter table girlfriend add address varchar(30)");
			break;

		default:
			break;
		}
	}

}
