package com.example.android_staticfragment.fragment;

import java.util.ArrayList;

import com.example.android_staticfragment.MainActivity;
import com.example.android_staticfragment.R;

import android.R.string;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LeftFragment extends Fragment {

	private ListView left_view;
	private ArrayList<String> dataList;

	// 放置图片
	int[] resId = new int[] { R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5 };

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

		left_view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// Toast.makeText(getActivity(), position+"", 0).show();

				MainActivity mainActivity = (MainActivity) getActivity();

				FragmentManager supportFragmentManager = mainActivity.getSupportFragmentManager();

				RightFragment right_fragment = (RightFragment) supportFragmentManager
						.findFragmentById(R.id.right_fragment);
				// 获取rightFragment
				right_fragment.setCurrentImage(resId[position]);

			}
		});

	}

	private void initData() {
		dataList = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
			dataList.add("这是第" + i + "条数据");
		}

	}

}
