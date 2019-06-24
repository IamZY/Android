package com.example.android_datetimedialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	private TextView tv_time;
	private TextView tv_date;
	private Calendar calendar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv_date = (TextView) findViewById(R.id.tv_date);
		tv_time = (TextView) findViewById(R.id.tv_time);

		calendar = Calendar.getInstance();

	}

	public void setDate(View view) {
		// 设置日期弹框
		DatePickerDialog datePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				tv_date.setText(year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
			}
		}, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

		datePickerDialog.show();

	}

	public void setTime(View view) {
		TimePickerDialog timePickerDialog = new TimePickerDialog(this, new OnTimeSetListener() {

			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				tv_time.setText(hourOfDay + "时" + minute + "分");
			}
		}, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
		
		timePickerDialog.show();
	}

}
