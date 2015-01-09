package com.phb.draft.demo.view;

import com.phb.draft.R;
import com.phb.draft.R.layout;
import com.phb.draft.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CheckBoxDemo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_box_demo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.check_box_demo, menu);
		return true;
	}

}
