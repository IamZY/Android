package com.example.android_contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {

	private static final String TABLE_NAME = "person";
	private MySqliteOpenHelper sqliteOpenHelper;

	@Override
	public boolean onCreate() {
		sqliteOpenHelper = new MySqliteOpenHelper(getContext());
		return false;
	}

	/**
	 * ≤Â»Î ˝æ›
	 * 
	 * @param uri
	 * @param projection
	 * @param selection
	 * @param selectionArgs
	 * @param sortOrder
	 * @return
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		Cursor cursor = sqliteOpenHelper.getReadableDatabase().query(TABLE_NAME, projection, selection, selectionArgs, null, null,
				sortOrder);
		return cursor;
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		sqliteOpenHelper.getReadableDatabase().insert(TABLE_NAME, null, values);
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		sqliteOpenHelper.getReadableDatabase().delete(TABLE_NAME, selection, selectionArgs);
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		sqliteOpenHelper.getReadableDatabase().update(TABLE_NAME, values, selection, selectionArgs);
		return 0;
	}

}
