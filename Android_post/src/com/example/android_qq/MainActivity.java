package com.example.android_qq;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.net.UrlQuerySanitizer;
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
 * 1-开启子线程，进行网络访问 2-定义请求路径 3-打开网络连接 4-设置请求方式为POST 5-设置输送给服务器消息 6-获取输出流
 * 7-拼接参数信息，并输出到服务器 8-获取响应码 9-获取流信息，转成字符串 10-主线程更新UI
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
		//
		try {
			// 获取网络路径
			URL url = new URL(path);
			// 打开连接
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			// 设置请求方式
			httpURLConnection.setRequestMethod("POST");
			// 连接超时时间
			httpURLConnection.setConnectTimeout(5000);
			// 设置读取超时时间
			httpURLConnection.setReadTimeout(5000);
			// 设置向外输出
			httpURLConnection.setDoOutput(true);
			// 输出流，将信息发送给服务器-实体内容里边
			OutputStream outputStream = httpURLConnection.getOutputStream();
			// 请求参数
			String requestArgs = "key=" + key + "&qq=" + et_number.getText().toString();
			// 转成字节数组发送给服务器
			outputStream.write(requestArgs.getBytes());
			// 获取状态码
			int responseCode = httpURLConnection.getResponseCode();
			if (responseCode == 200) {
				// 成功
				InputStream inputStream = httpURLConnection.getInputStream();
				String content = StreamUtils.parseStream(inputStream);
				// 发送给主线程
				Message msg = Message.obtain();
				msg.what = SUCCESS;
				msg.obj = content;
				handler.sendMessage(msg);
			} else {
				// 失败了
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
