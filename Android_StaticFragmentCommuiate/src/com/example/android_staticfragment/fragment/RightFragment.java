package com.example.android_staticfragment.fragment;

import com.example.android_staticfragment.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class RightFragment extends Fragment {

	private ImageView imageView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.right_fragment, null);
		imageView = (ImageView) view.findViewById(R.id.imageView);
		
		return view;
	}

	public void setCurrentImage(int resId) {
		// TODO Auto-generated method stub
		imageView.setImageResource(resId);
	}
	
	
}
