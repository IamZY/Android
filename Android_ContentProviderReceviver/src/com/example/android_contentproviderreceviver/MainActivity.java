package com.example.android_contentproviderreceviver;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	private ContentResolver contentResolver;
	private Uri uri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		contentResolver = getContentResolver();
		uri = Uri.parse("content://com.example.android_contentprovider");
	}

	public void add(View view) {
		ContentValues values = new ContentValues();
		values.put("name", "tom");
		values.put("age", 12);
		contentResolver.insert(uri, values);
	}

	public void delete(View view) {
		contentResolver.delete(uri, "name=?", new String[] { "张三" });
	}

	public void update(View view) {
		ContentValues values = new ContentValues();
		values.put("name", "jack");
		values.put("age", 21);
		contentResolver.update(uri, values, "name=?", new String[] { "李四" });
	}

	public void query(View view) {
		Cursor cursor = contentResolver.query(uri, new String[] { "name", "age" }, null, null, "age asc");
		while(cursor.moveToNext()) {
			String name = cursor.getString(cursor.getColumnIndex("name"));
			int age = cursor.getInt(cursor.getColumnIndex("age"));
		}
	}

}
