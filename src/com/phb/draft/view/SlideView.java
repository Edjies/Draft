package com.phb.draft.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class SlideView extends View {
	private float mDownX;
	private float mDownY;
	private float mSlop;
	private Context context;

	public SlideView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
	}

	public SlideView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}

	public SlideView(Context context) {
		super(context);
		this.context = context;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		super.onTouchEvent(event);
		switch (event.getActionMasked()) {
		case MotionEvent.ACTION_DOWN:
			Log.i("SlideView", "down");
			Log.e("11", "dfs");
			return handleTouchDown(event);
		case MotionEvent.ACTION_MOVE:
			Log.i("SlideView", "move");
			return handleTouchMove(event);
		case MotionEvent.ACTION_UP:
			Log.i("SlideView", "up");
			return handleTouchUp(event);
		default:
			break;
		}
		return false;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawARGB(255, 200, 200, 100);
	}
	
	private boolean handleTouchDown(MotionEvent event) {
		mDownX = event.getRawX();
		mDownY = event.getRawY();
		mSlop = ViewConfiguration.get(context).getScaledTouchSlop();
		return true;
	}
	
	@SuppressLint("NewApi")
	private boolean handleTouchMove(MotionEvent event) {
		float deltX = event.getRawX() - mDownX;
		float deltY = event.getRawY() - mDownY;
		
			setTranslationX(deltX);
			setTranslationY(deltY);
			Log.i("SlideView", "translation:" + String.valueOf(deltX));
			return true;

	}
	
	@SuppressLint("NewApi")
	private boolean handleTouchUp(MotionEvent event) {
		animate().translationX(0);
		animate().translationY(0);
		Log.i("SlideView", "translation:" + String.valueOf(mDownX - event.getRawX()));
		return true;
	}
	
}
