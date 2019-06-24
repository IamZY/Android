package com.example.android_dynamticfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.my_fragment, null);

		Bundle bundle = getArguments();
		String name = bundle.getString("name");

		TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
		tv_name.setText(name);
		return view;
	}

	/**
	 * 创建实例并传参
	 * 
	 * @param name
	 * @return
	 */
	public static Fragment getInstance(String name) {
		MyFragment myFragment = new MyFragment();
		Bundle bundle = new Bundle();
		bundle.putString("name", name);
		myFragment.setArguments(bundle);
		return myFragment;
	}

}
