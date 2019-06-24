package com.example.android_callreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CallReceiver extends BroadcastReceiver {

	private static final String TAG = "CallReceiver";

	/**
	 * Ω” ‹π„≤•
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		String number = getResultData();
		
		Log.i(TAG, "number"+number);
		
		setResultData("10086");
		
	}

}
