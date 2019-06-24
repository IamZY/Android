package com.example.android_sd;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity {

	protected static final String TAG = "MainActivity";
	private ArrayList<File> fileArr = new ArrayList<File>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView listView = (ListView) findViewById(R.id.listView);
		// sd 卡根路径
		File sd_directory = Environment.getExternalStorageDirectory();

		scanPic(sd_directory, ".png");

		listView.setAdapter(new MyBaseAdapter(this, fileArr));

	}

	private void scanPic(File sd_directory, final String path) {
		File[] listFiles = sd_directory.listFiles(new FileFilter() {
			// 列出该路径i下所有文件和文件夹
			@Override
			public boolean accept(File pathname) {
				if (pathname.isFile() && pathname.getAbsolutePath().endsWith(path)) {
					Log.i(TAG, pathname.getAbsolutePath());
					// 将该文件添加到数组中
					return true;
				} else if (pathname.isDirectory()) {
					return true;
				}
				// 文件名后缀不是.png
				return false;
			}
		});

		if (listFiles != null) {
			for (File file : listFiles) {
				if (file.isFile()) {
					fileArr.add(file);
				} else {
					// 当前是文件夹
					scanPic(file, path);
				}
			}
		}

	}

}
