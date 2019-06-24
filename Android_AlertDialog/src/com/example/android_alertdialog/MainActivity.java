package com.example.android_alertdialog;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void dialog1(View view) {
		Builder builder = new Builder(this);
		builder.setTitle("真心话问答");
		builder.setMessage("are you ok?");
		builder.setIcon(R.drawable.ic_launcher);

		builder.setNegativeButton("no", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// 弹框消失
				dialog.dismiss();
				Toast.makeText(MainActivity.this, "no", 0).show();
			}
		});

		builder.setNeutralButton("-", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// 弹框消失
				dialog.dismiss();
				Toast.makeText(MainActivity.this, "-", 0).show();
			}
		});

		builder.setPositiveButton("ok", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// 弹框消失
				dialog.dismiss();
				Toast.makeText(MainActivity.this, "ok", 0).show();
			}
		});

		builder.show();

	}

	public void dialog2(View view) {
		Builder builder = new Builder(this);
		builder.setTitle("你喜欢哪里的电影");
		final String[] strings = new String[] { "a", "b", "c" };
		builder.setSingleChoiceItems(strings, 0, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, strings[which], 0).show();
				dialog.dismiss();
			}
		});

		builder.show();

	}

	public void dialog3(View view) {
		Builder builder = new Builder(this);
		builder.setTitle("你喜欢哪些的电影");
		final String[] strings = new String[] { "a", "b", "c" };
		builder.setMultiChoiceItems(strings, new boolean[] { false, true, false }, new OnMultiChoiceClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				Toast.makeText(MainActivity.this, strings[which] + isChecked, 0).show();
			}
		});
		
		builder.setPositiveButton("提交", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// 弹框消失
				Toast.makeText(MainActivity.this, "提交", 0).show();
				dialog.dismiss();
			}
		});

		builder.show();
	}
}
