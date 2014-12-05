package com.phb.draft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends ListActivity {
	private List<HashMap<String, String>> datas;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		datas = new ArrayList<HashMap<String, String>>();
		additem("View", "com.phb.draft.CustomViewActivity");
		additem("OpenGL", "com.phb.draft.MainOpenGLActivity");
		additem("Audio", "com.phb.draft.media.AudioRecoderActivity");
		additem("Test", "com.phb.draft.TestActivity");
		setListAdapter(new SimpleAdapter(this, datas, android.R.layout.simple_list_item_1,new String[]{ "title"}, new int[]{android.R.id.text1}));	
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		try {
			Intent intent = new Intent(this, Class.forName(datas.get(position).get("className")));
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void additem(String title, String className) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("title", title);
		map.put("className", className);
		datas.add(map);
	}
	
}
