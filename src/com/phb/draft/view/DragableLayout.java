package com.phb.draft.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
/**
 * 基于 ViewDragHelpe r的 child view 可拖动的布局
 * @author Edjies
 * @date 2014-12-5
 */
public class DragableLayout extends LinearLayout {
	private int range; // 最大可拖动范围
	private int distance;
	private int width;
	private int height;
	private View dragView;
	private ViewDragHelper mDragger;
	private ViewDragHelper.Callback mCallback = new ViewDragHelper.Callback() {
		
		public int clampViewPositionVertical(View child, int top, int dy) {
			if (Math.abs(top) > range) {
				return top - dy;
			}
			return top;
		};
		
		public int getViewVerticalDragRange(View child) {
			return range;
		};
		
		@Override
		public boolean tryCaptureView(View dragView, int arg1) {
			return true;
		}
		
		public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
			dragView.layout(left, top, left + width, top + height);
		};
		
		@Override
		public void onViewReleased(View releasedChild, float xvel, float yvel) {
			super.onViewReleased(releasedChild, xvel, yvel);
			if (mDragger.smoothSlideViewTo(releasedChild, 0, 0)) {
				 ViewCompat.postInvalidateOnAnimation(DragableLayout.this);
			}
		};
		
	};
	
	@Override
	public void computeScroll() {
		if (mDragger.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
	};

	public DragableLayout(Context context) {
		super(context);
	}
	
	public DragableLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		mDragger = ViewDragHelper.create(this, mCallback);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return mDragger.shouldInterceptTouchEvent(ev);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		 mDragger.processTouchEvent(event);
		 return true;
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
		dragView.layout(l, distance + t, l + width, distance + t + height);
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		dragView = getChildAt(0);
	}
	
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = dragView.getMeasuredWidth();
        height = dragView.getMeasuredHeight();
        range = width * 2;
    }

}
