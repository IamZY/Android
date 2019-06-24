package com.example.android_activityfragment;

import org.w3c.dom.Text;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewsFragment extends Fragment {

//	private String title;
//
//	public NewsFragment(String title) {
//		this.title = title;
//	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		TextView textView = new TextView(getActivity());
		
		Bundle bundle = this.getArguments();
		String url = bundle.getString("url");
		textView.setText(url);
		return textView;
	}
	
	public NewsFragment() {
		// TODO Auto-generated constructor stub
	}

	public static Fragment getInstance(String url) {
		NewsFragment newsFragment = new NewsFragment();
		// ´´½¨Buddle
		Bundle bundle = new Bundle();
		bundle.putString("url", url);
		newsFragment.setArguments(bundle);
		return newsFragment;
	}
	
}
