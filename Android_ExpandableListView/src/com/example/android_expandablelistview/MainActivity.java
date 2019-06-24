package com.example.android_expandablelistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	String[] groupNames = new String[] { "好友", "同学" };
	String[][] childNames = new String[][] { { "a", "b", "c", "d" }, { "e", "f", "g" } };

	int[][] childIcons = new int[][] { { R.drawable.a10, R.drawable.a11, R.drawable.a12, R.drawable.a9 },
			{ R.drawable.a8, R.drawable.a7, R.drawable.a6 } };
	private ExpandableListView expandableListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		expandableListView = (ExpandableListView) findViewById(R.id.listView);
		expandableListView.setAdapter(new ExpandableAdapter(this, groupNames, childNames, childIcons));

		// 设置展开的监听事件
		expandableListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
				// 遍历所有分组
				for (int i = 0; i < groupNames.length; i++) {
					// 打开的不是i
					if (i != groupPosition) {
						expandableListView.collapseGroup(i);
					}
				}
			}
		});
		// 设置点击子条目的监听事件
		expandableListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition,
					long id) {
				Toast.makeText(MainActivity.this, "跟" + childNames[groupPosition][childPosition] + "聊天", 0).show();

				return true;
			}
		});
	}

}
