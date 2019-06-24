package com.example.android_progressdialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void showProgressDialog1(View view) {
		ProgressDialog dialog = new ProgressDialog(this);
		dialog.setTitle("等待");
		dialog.setMessage("正在等待");
		dialog.show();
	}

	private int progress = 0;

	public void showProgressDialog2(View view) {
		final ProgressDialog dialog = new ProgressDialog(this);
		dialog.setTitle("等待");
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.setCanceledOnTouchOutside(false);
		dialog.show();

		new Thread() {

			public void run() {
				while (progress <= 100) {
					dialog.setProgress(progress);
					if (progress == 100) {
						progress = 0;
						dialog.dismiss();
						break;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					progress++;
				}
			};
		}.start();

	}
}
