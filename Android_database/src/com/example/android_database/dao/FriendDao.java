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
	 * ��������
	 * 
	 * @param name
	 * @param age
	 */
	public void insert(String name, int age) {
		// ��ȡ�ɶ���д���ݿ�
		SQLiteDatabase db = helper.getWritableDatabase();
		// �����ݿ��в�������
		db.execSQL("insert into girlfriend (name,age) values(?,?)", new Object[] { name, age });
		// �ر����ݿ�
		db.close();
	}

	/**
	 * ɾ��ĳ������
	 * 
	 * @param name
	 */
	public void delete(String name) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from girlfriend where name = ?", new Object[] { name });
		db.close();
	}

	// �ѷ������޸ĳɷ�� 30
	public void update(String oldName, String newName, int age) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("update girlfriend set name= ?,age = ? where name = ?", new Object[] { newName, age, oldName });
		db.close();
	}

	/**
	 * ��������,ͨͨ��ѯ
	 */
	public ArrayList<GirlFriend> query() {
		// ��ȡһ���ɶ������ݿ�
		SQLiteDatabase db = helper.getReadableDatabase();
		// �α꼯
		Cursor cursor = db.rawQuery("select * from girlfriend", null);
		// �������������
		friendList.clear();
		// �����ƶ�ȡ����
		while (cursor.moveToNext()) {
			// �Ȼ�ȡ���ֶ������е�����ֵ,�ٻ�ȡ��ǰ���±ߵ�����
			String name = cursor.getString(cursor.getColumnIndex("name"));
			int age = cursor.getInt(cursor.getColumnIndex("age"));
			// ������
			friendList.add(new GirlFriend(name, age));
			Log.i(TAG, "name" + name + "age" + age);
		}
		return friendList;
	}

}
