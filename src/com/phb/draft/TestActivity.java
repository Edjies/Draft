package com.phb.draft;

import com.phb.draft.view.EventDemoView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends Activity {
	private EventDemoView mBt;
	private TextView mTvLog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		setViews();
		setListeners();
		initData();
	}
	
	public void setViews() {
		mBt = (EventDemoView) findViewById(R.id.mBt);
		mTvLog = (TextView) findViewById(R.id.tv_log);
		mBt.setLogView(mTvLog);
	}
	
	public void setListeners() {
		
	}
	
	public void initData() {
		
	}
	
	
}
