package com.ntuzy.button;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {  //������ implements OnClickListener {

	private ImageView view;

	/**
	 * Activity һ�����͵��õķ��� Java main
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ����������Ĳ���
		setContentView(R.layout.activity_main);
		// ��̬
		Button btClick = (Button) findViewById(R.id.bt_click);
		
		view = (ImageView) findViewById(R.id.iv_pic);
		
		// �԰�ťע�������
		// ��һ�� �����ڲ���
//		btClick.setOnClickListener(new OnClickListener() {
//			
//			// �������ť ��ָ̧��ʱ
//			@Override
//			public void onClick(View v) {
//				view.setImageResource(R.drawable.ah);
//			}
//		});
		
		// �ڶ���
//		btClick.setOnClickListener(new MyClickListener());
		
		// ������
//		btClick.setOnClickListener(this);
		
	}
	
	// ������
	public void showPic(View v) {
		view.setImageResource(R.drawable.ah);
	}

	/**
	 * �ڲ���
	 * @author IamZY
	 *
	 */
	class MyClickListener implements OnClickListener
	{
		@Override
		public void onClick(View v) {
			view.setImageResource(R.drawable.ah);
		}
	}

	/**
	 * ������
	 */
//	@Override
//	public void onClick(View v) {
//		switch (v.getId()) {
//		case R.id.bt_click:
//			view.setImageResource(R.drawable.ah);
//			break;
//
//		default:
//			break;
//		}
//	}
	

	
}





