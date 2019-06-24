package com.example.android_dynamticfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LoginFragment extends Fragment implements OnClickListener {

	private TextView username;
	private TextView password;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.login_fragment, null);

		username = (TextView) view.findViewById(R.id.username);
		password = (TextView) view.findViewById(R.id.password);
		Button button = (Button) view.findViewById(R.id.submit);

		button.setOnClickListener(this);

		return view;
	}

	@Override
	public void onClick(View v) {
		String _username = username.getText().toString();
		
		Fragment fragment = MyFragment.getInstance(_username);
		MainActivity mainActivity = (MainActivity) getActivity();
		mainActivity.changeFragment(fragment,"MyFragment");
	}

}
