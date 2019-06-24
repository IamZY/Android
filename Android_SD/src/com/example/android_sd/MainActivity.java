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
		// sd ����·��
		File sd_directory = Environment.getExternalStorageDirectory();

		scanPic(sd_directory, ".png");

		listView.setAdapter(new MyBaseAdapter(this, fileArr));

	}

	private void scanPic(File sd_directory, final String path) {
		File[] listFiles = sd_directory.listFiles(new FileFilter() {
			// �г���·��i�������ļ����ļ���
			@Override
			public boolean accept(File pathname) {
				if (pathname.isFile() && pathname.getAbsolutePath().endsWith(path)) {
					Log.i(TAG, pathname.getAbsolutePath());
					// �����ļ���ӵ�������
					return true;
				} else if (pathname.isDirectory()) {
					return true;
				}
				// �ļ�����׺����.png
				return false;
			}
		});

		if (listFiles != null) {
			for (File file : listFiles) {
				if (file.isFile()) {
					fileArr.add(file);
				} else {
					// ��ǰ���ļ���
					scanPic(file, path);
				}
			}
		}

	}

}
