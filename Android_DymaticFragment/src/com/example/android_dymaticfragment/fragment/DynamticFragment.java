package com.example.android_dymaticfragment.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DynamticFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		TextView view = new TextView(getActivity());
		view.setText("���Ƕ�̬");
		return view;
	}
	
}
