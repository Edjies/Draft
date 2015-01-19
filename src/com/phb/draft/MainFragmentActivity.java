package com.phb.draft;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.ListView;

public class MainFragmentActivity extends Activity {
	private DrawerLayout mDrawerLayout;
	private ListView mLvDrawer;
	private FrameLayout mFlMain;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_fragment);
		setViews();
		setListeners();
		initData();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void setViews() {
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mLvDrawer = (ListView) findViewById(R.id.drawer);
		mFlMain = (FrameLayout) findViewById(R.id.fragment_main);
	} 
	
	private void setListeners() {
		
	}
	
	private void initData() {
		
	}
}
