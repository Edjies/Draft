package com.phb.draft.iqdii.view;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class FaceGridView extends GridView {
	private List<Integer> ids;
	private List<String> names;
	private Context context;
	public FaceGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}

	public FaceGridView(Context context) {
		super(context);
		this.context = context;
		
	}
	
}
