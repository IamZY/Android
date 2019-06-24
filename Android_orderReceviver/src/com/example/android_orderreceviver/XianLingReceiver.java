package com.example.android_orderreceviver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class XianLingReceiver extends BroadcastReceiver {

	private static final String TAG = "XianLingReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		String resultData = getResultData();
		Log.i(TAG, resultData);
		
		setResultData("每人上交全部");
	}

}
