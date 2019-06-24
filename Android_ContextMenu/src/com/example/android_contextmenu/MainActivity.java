package com.example.android_contextmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView tv_view = (TextView) findViewById(R.id.tv_title);
		
		this.registerForContextMenu(tv_view);
		
	}
	
	/**
	 * 生成上下文菜单
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		// groupid
		// itemid
		// order
		// title 菜单内容
		menu.add(0,1,ContextMenu.NONE,"赶走经纪人");
		menu.add(0,2,ContextMenu.NONE,"弄走隔壁老王");
		menu.add(0,3,ContextMenu.NONE,"学习");
	}
	
	
	/**
	 * 相应上下文菜单
	 */
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int itemId = item.getItemId();
		switch (itemId) {
		case 1:
			Toast.makeText(this, "赶走经纪人", 0).show();
			break;
		case 2:
			Toast.makeText(this, "赶走老王", 0).show();
			break;
		case 3:
			Toast.makeText(this, "学习", 0).show();			
			break;

		default:
			break;
		}
		return super.onContextItemSelected(item);
	}

	
}
