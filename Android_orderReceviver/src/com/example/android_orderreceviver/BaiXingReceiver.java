package com.example.android_orderreceviver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BaiXingReceiver extends BroadcastReceiver {

	private static final String TAG = "BaiXingReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		String resultData = getResultData();
		Log.i(TAG, "∞Ÿ–’…œΩª" + resultData);

	}

}
