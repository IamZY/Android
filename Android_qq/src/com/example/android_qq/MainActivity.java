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
 * 0-�����߳��н����������� 1-����һ��URL 2-������-��HttpUrlConnection�������� 3-�ж���Ӧ�� 4-��ȡ��������Ϣ
 * 5-ת���ַ��� 6-�����߳��и���UI 7-��ӷ�������Ȩ��
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
			// �ɹ�
			case SUCCESS:
				String content = (String) msg.obj;
				tv_content.setText(content);
				break;
			// ʧ��
			case FAILD:
				int code = (Integer) msg.obj;
				Toast.makeText(MainActivity.this, "����ʧ��,������" + code, 0).show();
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
		// ���������漰����ʱ��������Ҫ�ŵ����߳�
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
				// ȡ����Ϣ
				InputStream inputStream = openConnection.getInputStream();
				// ��������ת���ı�
				String content = StreamUtils.parseStream(inputStream);
				// ��ʾ��textView��
				// tv_content.setText(content);
				Message msg = Message.obtain();
				msg.what = SUCCESS;
				msg.obj = content;
				handler.sendMessage(msg);
			} else {
				// Toast.makeText(MainActivity.this, "����ʧ��" + responseCode, 0)
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
