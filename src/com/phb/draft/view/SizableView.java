package com.phb.draft.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/**
 * 关于 onMeasure方法的详细使用, 自适应大小
 * @author Edjies
 * @date 2014-12-5
 */
public class SizableView extends View {
	int desiredWidth = 200;
	int desireHeight = 400;
	int width;
	int height;

	public SizableView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initData();
	}

	public SizableView(Context context) {
		super(context);
		initData();
	}
	
	private void initData() {
		
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		// 宽度测量
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		
		switch (widthMode) {
		case MeasureSpec.AT_MOST:
			width = Math.min(widthSize, desiredWidth);
			break;
		case MeasureSpec.EXACTLY:
			width = widthSize;
			break;
		case MeasureSpec.UNSPECIFIED:
			width = desiredWidth;
			break;
		}
		// 高度测量
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);
		
		switch (heightMode) {
		case MeasureSpec.AT_MOST:
			height = Math.min(heightSize, desireHeight);
			break;
		case MeasureSpec.EXACTLY:
			height = heightSize;
			break;
		case MeasureSpec.UNSPECIFIED:
			height = desireHeight;	
			break;
		}
		
		setMeasuredDimension(width, height);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawARGB(getRandom(), getRandom(), getRandom(), getRandom());
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if(desiredWidth == 200) {
				desiredWidth = 400;
				desireHeight = 800;
			}else {
				desiredWidth = 200;
				desireHeight = 400;
			}
			break;
		case MotionEvent.ACTION_UP:
			requestLayout();
			invalidate();
			break;
		default:
			break;
		}
		
		return true;
		
	}
	
	private int getRandom() {
		return (int) Math.round(Math.random() * 255);
	}
}
