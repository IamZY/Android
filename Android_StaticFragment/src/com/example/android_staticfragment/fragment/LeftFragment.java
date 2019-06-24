package com.example.android_staticfragment.fragment;

import java.util.ArrayList;

import com.example.android_staticfragment.R;

import android.R.string;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LeftFragment extends Fragment {

	private ListView left_view;
	private ArrayList<String> dataList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.left_fragment, null);
		left_view = (ListView) view.findViewById(R.id.listView);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData();
		left_view.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dataList));
	}

	private void initData() {
		dataList = new ArrayList<String>();

		for (int i = 0; i < 20; i++) {
			dataList.add("这是第" + i + "条数据");
		}

	}

}
