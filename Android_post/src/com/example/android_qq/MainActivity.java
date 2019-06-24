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
 * 1-�������̣߳������������ 2-��������·�� 3-���������� 4-��������ʽΪPOST 5-�������͸���������Ϣ 6-��ȡ�����
 * 7-ƴ�Ӳ�����Ϣ��������������� 8-��ȡ��Ӧ�� 9-��ȡ����Ϣ��ת���ַ��� 10-���̸߳���UI
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
		//
		try {
			// ��ȡ����·��
			URL url = new URL(path);
			// ������
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			// ��������ʽ
			httpURLConnection.setRequestMethod("POST");
			// ���ӳ�ʱʱ��
			httpURLConnection.setConnectTimeout(5000);
			// ���ö�ȡ��ʱʱ��
			httpURLConnection.setReadTimeout(5000);
			// �����������
			httpURLConnection.setDoOutput(true);
			// �����������Ϣ���͸�������-ʵ���������
			OutputStream outputStream = httpURLConnection.getOutputStream();
			// �������
			String requestArgs = "key=" + key + "&qq=" + et_number.getText().toString();
			// ת���ֽ����鷢�͸�������
			outputStream.write(requestArgs.getBytes());
			// ��ȡ״̬��
			int responseCode = httpURLConnection.getResponseCode();
			if (responseCode == 200) {
				// �ɹ�
				InputStream inputStream = httpURLConnection.getInputStream();
				String content = StreamUtils.parseStream(inputStream);
				// ���͸����߳�
				Message msg = Message.obtain();
				msg.what = SUCCESS;
				msg.obj = content;
				handler.sendMessage(msg);
			} else {
				// ʧ����
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
