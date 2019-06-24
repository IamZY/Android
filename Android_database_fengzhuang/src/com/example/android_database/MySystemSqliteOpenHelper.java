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
	 *            ������
	 * @param name
	 *            ���ݿ�����
	 * @param factory
	 *            �α깤�� null
	 * @param version
	 *            �汾��
	 */
	public MySystemSqliteOpenHelper(Context context) {
		super(context, "text.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * ���ݿⴴ�����еķ��� ֻ�ᱻִ��һ��
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table girlfriend " + "(_id integer primary key autoincrement,"
				+ "name varchar(20),age integer)");
	}

	/**
	 * ����·���µķ���
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
			// �汾һ�����ɰ汾2 ��Ҫ���һ��
			db.execSQL("alter table girlfriend add size integer");
			// break;
		case 2:
			// �汾�������ɰ汾3 �����һ��
			db.execSQL("alter table girlfriend add address varchar(30)");
			break;

		default:
			break;
		}
	}

}
