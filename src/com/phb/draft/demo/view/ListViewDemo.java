package com.phb.draft.demo.view;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.phb.draft.R;

public class ListViewDemo extends Activity{
	private ListView mLv;
	private ArrayList<Integer> datas; 
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview_demo);
		mLv = (ListView) findViewById(R.id.lv);
		getItemData();
		mLv.setAdapter(new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, android.R.id.text1, datas));
		mLv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				view.setTranslationX(20);
				mLv.setTranslationY(100);
				
			}
		});
		
	}
	
	
	
	private void getItemData() {
		datas = new ArrayList<Integer>();
		datas.add(1);
		datas.add(2);
		datas.add(3);
		datas.add(4);
		datas.add(5);
		datas.add(6);
	}


}
