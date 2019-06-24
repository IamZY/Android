package com.example.android_orderreceviver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ShangShuReceiver extends BroadcastReceiver {

	private static final String TAG = "ShangShuReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		String resultData = getResultData();
		Log.i(TAG, resultData);
		
		setResultData("每人上交2但");
	}

}
