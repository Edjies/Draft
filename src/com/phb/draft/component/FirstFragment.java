package com.phb.draft.component;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class FirstFragment extends ListFragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, new String[]{"abc","efg","hij","klm"}));
	}
}
