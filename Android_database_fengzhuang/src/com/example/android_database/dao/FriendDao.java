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
	 * ��������
	 * 
	 * @param name
	 * @param age
	 */
	public void insert(String name, int age) {
		// ��ȡ�ɶ���д���ݿ�
		SQLiteDatabase db = helper.getWritableDatabase();
		// �����ݿ��в�������
		// Ĭ�� null
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("age", age);
		db.insert(TABLE_NAME, null, values);
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
		db.delete(TABLE_NAME, "name=?", new String[] { name });
		db.close();
	}

	// �ѷ������޸ĳɷ�� 30
	public void update(String oldName, String newName, int age) {
		SQLiteDatabase db = helper.getWritableDatabase();
		// ��Ҫ�޸ĵ���Ϣ
		ContentValues values = new ContentValues();
		values.put("name", newName);
		values.put("age", age);
		db.update(TABLE_NAME, values, "name=?", new String[] { oldName });
		db.close();
	}

	/**
	 * ��������,ͨͨ��ѯ
	 */
	@SuppressLint("NewApi")
	public ArrayList<GirlFriend> query() {
		// ��ȡһ���ɶ������ݿ�
		SQLiteDatabase db = helper.getReadableDatabase();
		// �α꼯
		// �������������
		friendList.clear();
		// distinct �Ƿ��ظ�,true Ψһ
		// table ����
		// columns Ҫ��ѯ���� ���� new String{"name"} ��ѯ���о���null
		// selection �ж�����
		// selectionArgs �ж�����ռλ��������
		// groupBy ���� name
		// having �ͷ�����ʹ�� �ж�����
		// orderBy ����ʽ "age asc" ���������� "age desc" �����䵹��
		// limit ��ҳ "0,20"
		Cursor cursor = db.query(true, TABLE_NAME, null, null, null, null, null, null, null, null);

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
