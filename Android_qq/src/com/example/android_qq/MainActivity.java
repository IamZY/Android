package com.example.android_qq;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 0-在子线程中进行网络请求 1-定义一个URL 2-打开连接-对HttpUrlConnection做简单设置 3-判断响应码 4-获取请求流信息
 * 5-转成字符串 6-在主线程中更新UI 7-添加访问网络权限
 * 
 * @author iamzy
 *
 */
public class MainActivity extends Activity {
	private static final int SUCCESS = 0;
	private static final int FAILD = 1;
	private EditText et_number;
	private TextView tv_content;
	private String path = "http://japi.juhe.cn/qqevaluate/qq";
	private String key = "96efc220a4196fafdfade0c9d1e897ac";
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			// 成功
			case SUCCESS:
				String content = (String) msg.obj;
				tv_content.setText(content);
				break;
			// 失败
			case FAILD:
				int code = (Integer) msg.obj;
				Toast.makeText(MainActivity.this, "请求失败,错误码" + code, 0).show();
				break;

			default:
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et_number = (EditText) findViewById(R.id.et_number);

		tv_content = (TextView) findViewById(R.id.tv_content);

	}

	public void getRequest(View v) {
		// 请求网络涉及到耗时操作，需要放到子线程
		// SecurityException: Permission denied (missing INTERNET permission?)
		new Thread() {
			public void run() {
				request();
			};
		}.start();

	}

	public void request() {
		String qqPath = path + "?" + "key=" + key + "&qq=" + et_number.getText().toString();

		try {
			URL url = new URL(qqPath);

			HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
			// openConnection.setRequestMethod("GET");
			openConnection.setConnectTimeout(3000);
			int responseCode = openConnection.getResponseCode();

			if (responseCode == 200) {
				// 取出信息
				InputStream inputStream = openConnection.getInputStream();
				// 将输入流转成文本
				String content = StreamUtils.parseStream(inputStream);
				// 显示到textView上
				// tv_content.setText(content);
				Message msg = Message.obtain();
				msg.what = SUCCESS;
				msg.obj = content;
				handler.sendMessage(msg);
			} else {
				// Toast.makeText(MainActivity.this, "请求失败" + responseCode, 0)
				// .show();
				Message msg = Message.obtain();
				msg.what = FAILD;
				msg.obj = responseCode;
				handler.sendMessage(msg);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
