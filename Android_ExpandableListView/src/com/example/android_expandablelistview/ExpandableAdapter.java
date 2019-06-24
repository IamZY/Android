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
	 * ��ȡ��ĸ���
	 */
	@Override
	public int getGroupCount() {
		return groupNames.length;
	}

	/**
	 * ��ȡÿһ������������Ŀ�ĸ���
	 */
	@Override
	public int getChildrenCount(int groupPosition) {
		return childNames[groupPosition].length;
	}

	/**
	 * ��ȡ�������
	 */
	@Override
	public Object getGroup(int groupPosition) {
		return groupNames[groupPosition];
	}

	/**
	 * ��ȡ����Ŀ����������
	 */
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return childNames[groupPosition][childPosition];
	}

	/**
	 * ��ȡ��ǰ���id
	 */
	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	/**
	 * ��ȡ����Ŀ��id
	 */
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	/**
	 * �Ƿ��й̶�id
	 */
	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * ��ȡ��չʾЧ��
	 */
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		// ʵ��������Ĳ���Ч��
		View view = View.inflate(context, R.layout.group_layout, null);
		TextView tv_group_name = (TextView) view.findViewById(R.id.tv_group_name);
		// �������չʾ����
		tv_group_name.setText(groupNames[groupPosition]);
		return view;
	}

	/**
	 * ��������ĿչʾЧ��
	 */
	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		// ʵ��������Ŀ����
		View view = View.inflate(context, R.layout.child_layout, null);
		// �ҿؼ�
		TextView tv_child_name = (TextView) view.findViewById(R.id.tv_child_name);
		ImageView iv_child_icon = (ImageView) view.findViewById(R.id.iv_child_icon);
		// ����groupPosition��childPosition��ȡ��ǰҪչʾ������
		tv_child_name.setText(childNames[groupPosition][childPosition]);
		iv_child_icon.setImageResource(childIcons[groupPosition][childPosition]);
		return view;
	}

	/**
	 * ����Ŀ�Ƿ��ѡ
	 */
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}
