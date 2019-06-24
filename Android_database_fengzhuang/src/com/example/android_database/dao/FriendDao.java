package com.example.android_database.dao;

import java.util.ArrayList;

import com.example.android_database.MySystemSqliteOpenHelper;
import com.example.android_database.bean.GirlFriend;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class FriendDao {

	private static final String TAG = "FriendDao";
	private static final String TABLE_NAME = "girlfriend";
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
		// 默认 null
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("age", age);
		db.insert(TABLE_NAME, null, values);
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
		db.delete(TABLE_NAME, "name=?", new String[] { name });
		db.close();
	}

	// 把范冰冰修改成凤姐 30
	public void update(String oldName, String newName, int age) {
		SQLiteDatabase db = helper.getWritableDatabase();
		// 将要修改的信息
		ContentValues values = new ContentValues();
		values.put("name", newName);
		values.put("age", age);
		db.update(TABLE_NAME, values, "name=?", new String[] { oldName });
		db.close();
	}

	/**
	 * 无需条件,通通查询
	 */
	@SuppressLint("NewApi")
	public ArrayList<GirlFriend> query() {
		// 获取一个可读的数据库
		SQLiteDatabase db = helper.getReadableDatabase();
		// 游标集
		// 先清除集合数据
		friendList.clear();
		// distinct 是否不重复,true 唯一
		// table 表名
		// columns 要查询的列 数组 new String{"name"} 查询所有就是null
		// selection 判断条件
		// selectionArgs 判断条件占位符的内容
		// groupBy 分组 name
		// having 和分组结合使用 判断条件
		// orderBy 排序方式 "age asc" 按年龄正序 "age desc" 按年龄倒叙
		// limit 分页 "0,20"
		Cursor cursor = db.query(true, TABLE_NAME, null, null, null, null, null, null, null, null);

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
