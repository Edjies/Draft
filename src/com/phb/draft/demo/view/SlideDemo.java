package com.phb.draft.demo.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import android.widget.Button;

import com.phb.draft.R;
import com.phb.draft.view.SlideView;

public class SlideDemo extends Activity {
	private SlideView mSlide;
	private Button mBt1;
	private Button mBt2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slide_demo);
		setViews();
		setListeners();
		initData();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.slide_demo, menu);
		return true;
	}
	
	private void setViews() {
		mSlide = (SlideView) findViewById(R.id.v_slide);
		mBt1 = (Button) findViewById(R.id.bt_01);
		mBt2 = (Button) findViewById(R.id.bt_02);
	}
	
	private void setListeners() {
		
	}
	
	private void initData() {
		
	}

}
