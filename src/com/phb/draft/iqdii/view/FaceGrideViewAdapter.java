package com.phb.draft.iqdii.view;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class FaceGrideViewAdapter extends BaseAdapter {
	private Context context;
	private List<Integer> ids;
	private List<String> names;
	
	public FaceGrideViewAdapter(Context context, List<Integer> ids, List<String> names) {
		this.context = context;
		this.ids = ids;
		this.names = names;
	}
	@Override
	public int getCount() {
		return ids.size();
	}

	@Override
	public Object getItem(int position) {
		return ids.get(position);
	}

	@Override
	public long getItemId(int position) {
		return ids.get(position);
	}

	@Override
	public View getView(int position, View revertView, ViewGroup arg2) {
		Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), ids.get(position));
		ImageView imgView = new ImageView(context);
		LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		imgView.setLayoutParams(lp);
		imgView.setImageBitmap(bitmap);
		return imgView;
	}
}
