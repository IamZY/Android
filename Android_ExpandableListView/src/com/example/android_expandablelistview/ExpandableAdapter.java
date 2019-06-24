package com.example.android_expandablelistview;

import android.R.raw;
import android.content.Context;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandableAdapter extends BaseExpandableListAdapter {

	private Context context;
	private String[] groupNames;
	private String[][] childNames;
	private int[][] childIcons;

	public ExpandableAdapter(Context context, String[] groupNames, String[][] childNames, int[][] childIcons) {
		this.context = context;
		this.groupNames = groupNames;
		this.childNames = childNames;
		this.childIcons = childIcons;
	}

	/**
	 * 获取组的个数
	 */
	@Override
	public int getGroupCount() {
		return groupNames.length;
	}

	/**
	 * 获取每一个分组中子条目的个数
	 */
	@Override
	public int getChildrenCount(int groupPosition) {
		return childNames[groupPosition].length;
	}

	/**
	 * 获取组的数据
	 */
	@Override
	public Object getGroup(int groupPosition) {
		return groupNames[groupPosition];
	}

	/**
	 * 获取子条目的数据内容
	 */
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return childNames[groupPosition][childPosition];
	}

	/**
	 * 获取当前组的id
	 */
	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	/**
	 * 获取子条目的id
	 */
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	/**
	 * 是否有固定id
	 */
	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 获取组展示效果
	 */
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		// 实例化分组的布局效果
		View view = View.inflate(context, R.layout.group_layout, null);
		TextView tv_group_name = (TextView) view.findViewById(R.id.tv_group_name);
		// 设置组的展示内容
		tv_group_name.setText(groupNames[groupPosition]);
		return view;
	}

	/**
	 * 设置子条目展示效果
	 */
	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		// 实例化子条目布局
		View view = View.inflate(context, R.layout.child_layout, null);
		// 找控件
		TextView tv_child_name = (TextView) view.findViewById(R.id.tv_child_name);
		ImageView iv_child_icon = (ImageView) view.findViewById(R.id.iv_child_icon);
		// 根据groupPosition和childPosition获取当前要展示的内容
		tv_child_name.setText(childNames[groupPosition][childPosition]);
		iv_child_icon.setImageResource(childIcons[groupPosition][childPosition]);
		return view;
	}

	/**
	 * 子条目是否可选
	 */
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}
