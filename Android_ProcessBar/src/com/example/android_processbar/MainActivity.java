package com.example.android_processbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ProgressBar bar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bar = (ProgressBar) findViewById(R.id.progressBar1);

	}

	public void setProgressBar(View v) {

		new Thread() {
			public void run() {
				
				int progress = 0;
				while (progress <= 100) {
					bar.setProgress(progress);
					bar.setSecondaryProgress(progress + 10);

					if (progress == 100) {
						progress = 0;
						break;
					}

					progress++;
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();

		

	}

}
