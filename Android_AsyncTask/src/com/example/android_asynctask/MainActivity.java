package com.example.android_asynctask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	private ProgressBar pb_progress;
	private ImageView iv_pic;

	private String path = "http://pic22.nipic.com/20120628/10377605_163917692102_2.jpg";

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == 0) {
				Bitmap bitmap = (Bitmap) msg.obj;
				iv_pic.setImageBitmap(bitmap);

				pb_progress.setVisibility(View.GONE);
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		pb_progress = (ProgressBar) findViewById(R.id.pb_progress);
		iv_pic = (ImageView) findViewById(R.id.iv_pic);

	}

	public void getPic(View v) {
		// getPicFromNet();
		// getAysncPic();
		getAndroidAysncPic();
	}

	private void getPicFromNet() {
		pb_progress.setVisibility(View.VISIBLE);

		new Thread() {
			public void run() {

				try {
					URL url = new URL(path);
					HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
					openConnection.setConnectTimeout(3000);
					openConnection.setReadTimeout(3000);
					int responseCode = openConnection.getResponseCode();
					if (responseCode == 200) {
						InputStream inputStream = openConnection.getInputStream();
						Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);

						handler.obtainMessage(0, decodeStream).sendToTarget();

					} else {

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			};
		}.start();
	}

	public void getAysncPic() {
		PicAysncTask picAysncTask = new PicAysncTask();
		picAysncTask.execute(path);
	}

	public void getAndroidAysncPic() {
		/**
		 * 第一个参数 请求的路径 可变参数 第二次参数 Void 更新进度 第三个参数 子线程请求返回的结果类型
		 */
		AsyncTask<String, Void, Bitmap> asyncTask = new AsyncTask<String, Void, Bitmap>() {

			@Override
			protected Bitmap doInBackground(String... params) {
				Bitmap decodeStream = null;
				try {
					URL url = new URL(params[0]);
					HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
					openConnection.setConnectTimeout(3000);
					openConnection.setReadTimeout(3000);
					int responseCode = openConnection.getResponseCode();
					if (responseCode == 200) {
						InputStream inputStream = openConnection.getInputStream();
						decodeStream = BitmapFactory.decodeStream(inputStream);

						handler.obtainMessage(0, decodeStream).sendToTarget();

					} else {

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return decodeStream;
			}

			@Override
			protected void onPreExecute() {
				pb_progress.setVisibility(View.VISIBLE);
			}

			@Override
			protected void onPostExecute(Bitmap result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result);
			}

		};
		// 执行任务
		asyncTask.execute(path);

	}

	class PicAysncTask extends MyAsyncTask<Bitmap> {

		@Override
		public void postExecute(Bitmap t) {
			iv_pic.setImageBitmap(t);
			pb_progress.setVisibility(View.GONE);
		}

		@Override
		public Bitmap doInBackGround(String path) {
			Bitmap decodeStream = null;
			try {
				URL url = new URL(path);
				HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
				openConnection.setConnectTimeout(3000);
				openConnection.setReadTimeout(3000);
				int responseCode = openConnection.getResponseCode();
				if (responseCode == 200) {
					InputStream inputStream = openConnection.getInputStream();
					decodeStream = BitmapFactory.decodeStream(inputStream);

					handler.obtainMessage(0, decodeStream).sendToTarget();

				} else {

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return decodeStream;
		}

		@Override
		public void preExecute() {
			// TODO Auto-generated method stub
			pb_progress.setVisibility(View.VISIBLE);
		}

	}

}
