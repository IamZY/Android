package com.example.android_database.dao;

import java.util.ArrayList;

import com.example.android_database.MySystemSqliteOpenHelper;
import com.example.android_database.bean.GirlFriend;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class FriendDao {

	private static final String TAG = "FriendDao";
	private MySystemSqliteOpenHelper helper;
	private ArrayList<GirlFriend> friendList = new ArrayList<GirlFriend>();

	public FriendDao(Context context) {
		helper = new MySystemSqliteOpenHelper(context);
	}

	/**
	 * 插入数据
	 * 
	 * @param name
	 * @param age
	 */
	public void insert(String name, int age) {
		// 获取可读可写数据库
		SQLiteDatabase db = helper.getWritableDatabase();
		// 往数据库中插入数据
		db.execSQL("insert into girlfriend (name,age) values(?,?)", new Object[] { name, age });
		// 关闭数据库
		db.close();
	}

	/**
	 * 删除某条数据
	 * 
	 * @param name
	 */
	public void delete(String name) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from girlfriend where name = ?", new Object[] { name });
		db.close();
	}

	// 把范冰冰修改成凤姐 30
	public void update(String oldName, String newName, int age) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("update girlfriend set name= ?,age = ? where name = ?", new Object[] { newName, age, oldName });
		db.close();
	}

	/**
	 * 无需条件,通通查询
	 */
	public ArrayList<GirlFriend> query() {
		// 获取一个可读的数据库
		SQLiteDatabase db = helper.getReadableDatabase();
		// 游标集
		Cursor cursor = db.rawQuery("select * from girlfriend", null);
		// 先清除集合数据
		friendList.clear();
		// 往下移动取数据
		while (cursor.moveToNext()) {
			// 先获取该字段所在列的索引值,再获取当前列下边的内容
			String name = cursor.getString(cursor.getColumnIndex("name"));
			int age = cursor.getInt(cursor.getColumnIndex("age"));
			// 做返回
			friendList.add(new GirlFriend(name, age));
			Log.i(TAG, "name" + name + "age" + age);
		}
		return friendList;
	}

}
