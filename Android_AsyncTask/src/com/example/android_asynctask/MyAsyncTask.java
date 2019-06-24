package com.example.android_asynctask;

import android.os.Handler;

public abstract class MyAsyncTask<T> {

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 0) {
				T t = (T) msg.obj;
				// 添加到主线程
				postExecute(t);
			}
		};
	};

	public void execute(final String path) {
		preExecute();

		new Thread() {
			public void run() {
				T t = doInBackGround(path);

				handler.obtainMessage(0, t).sendToTarget();

			};
		}.start();

	}

	public abstract void postExecute(T t);

	public abstract T doInBackGround(String path);

	public abstract void preExecute();
}
