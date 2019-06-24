package com.example.android_transaction;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqliteOpenHelper extends SQLiteOpenHelper {

	public MySqliteOpenHelper(Context context) {
		super(context, "bank.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table account(name varchar(20),money integer)");
		// 默认添加两条数据
		db.execSQL("insert into account(name,money) values(?,?)", new Object[] { "张三", 1000 });
		db.execSQL("insert into account(name,money) values(?,?)", new Object[] { "李四", 1000 });
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
