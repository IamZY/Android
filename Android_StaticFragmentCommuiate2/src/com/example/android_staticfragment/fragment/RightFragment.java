package com.example.android_staticfragment.fragment;

import com.example.android_staticfragment.R;
import com.example.android_staticfragment.fragment.LeftFragment.OnGirlChangedListener;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class RightFragment extends Fragment {

	private ImageView imageView;
	protected String TAG = "RightFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.right_fragment, null);
		imageView = (ImageView) view.findViewById(R.id.imageView);
		
		return view;
	}

	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// 先获取当前所在的activity
		FragmentManager manager = getActivity().getSupportFragmentManager();
		
		LeftFragment leftFragment = (LeftFragment) manager.findFragmentById(R.id.left_fragment);
		
		leftFragment.setOnGirlChangedListener(new OnGirlChangedListener() {
			
			@Override
			public void setCurrentGirl(int resId) {
				Log.i(TAG , "2222222222");
				imageView.setImageResource(resId);
			}
		});
		
	}
	
	
}
