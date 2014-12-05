package com.phb.draft.iqdii.view;

import java.util.List;
import java.util.Random;

import com.phb.draft.view.SizableView;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;

public class FacePagerViewAdapter extends PagerAdapter {
	private int count;
	private Context context;
	private List<Integer> ids;
	private List<String> names;
	private int numPerPage;
	public FacePagerViewAdapter(Context context, List<Integer> resIds, List<String> names, int numPerPage) {
		this.context = context;
		this.names = names;
		this.ids = resIds;
		this.numPerPage = numPerPage;
		this.count = resIds.size() / numPerPage;
	}
	@Override
	public int getCount() {
		return count;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
		
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		Log.i("adapter", "instantiate:" + position + "");
		FaceGridView view = new FaceGridView(context);	
		view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		view.setNumColumns(4);
		//view.setOnItemClickListener(itemListener);
		view.setAdapter(new FaceGrideViewAdapter(context, ids.subList(numPerPage * position, numPerPage * (position + 1)), names.subList(numPerPage * position, numPerPage * (position + 1))));
		container.addView(view);
		return view;
	}
}
