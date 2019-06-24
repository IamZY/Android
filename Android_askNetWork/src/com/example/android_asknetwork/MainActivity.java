package com.example.android_asknetwork;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	protected static final int MSG_PIG = 0;

	private ImageView imageView;

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			
			if(msg.what == MSG_PIG) {
				// ��ȡ��Ϣ���� �ж���Ϣ����
				int picId = (Integer) msg.obj;
				imageView.setImageResource(picId);
			}
			
		}; 
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageView = (ImageView) findViewById(R.id.imageView);
		
	}
	

	// ֻ�����̲߳��ܸ���ui
	public void getPic(View v) {
		// ����������ͼƬ
		
		new Thread() {
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ��ȡһ����Ϣ
				Message msg = Message.obtain();
				// ��ȡͼƬ
//				imageView.setImageResource(R.drawable.ic_launcher);
				msg.obj = R.drawable.ic_launcher;
				// ������Ϣ����
				msg.what = MSG_PIG;
				// �̼߳�ͨ��
				handler.sendMessage(msg);
			};
		}.start();
		
		
	}
	
	
}
