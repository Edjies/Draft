package com.phb.draft.demo.animation;

import com.phb.draft.R;
import com.phb.draft.R.layout;
import com.phb.draft.R.menu;

import android.os.Bundle;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class PropertyAnimationDemo extends Activity {
	private Button mBt01;
	private ValueAnimator mAnimator;
	private ShapeDrawable drawable;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_animation_demo);
		setViews();
		setListeners();
		initData();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.property_animation_demo, menu);
		return true;
	}
	
	private void setViews() {
		mBt01 = (Button) findViewById(R.id.bt1);
		
//		ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 2.0f);
//		animator.setDuration(300);	
//		animator.addUpdateListener(new AnimatorUpdateListener() {
//			
//			@SuppressLint("NewApi")
//			@Override
//			public void onAnimationUpdate(ValueAnimator animation) {
//				Log.i("Animation", String.valueOf(animation.getAnimatedFraction()) + ":" + String.valueOf(animation.getAnimatedValue()));
//				
//			}
//		});
//		animator.start();
	}
	
	private void setListeners() {
		mBt01.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mAnimator.start();
			}
		});
	}
	
	
	
	private void initData() {
		mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
		mAnimator.setDuration(1000);
		mAnimator.addUpdateListener(new AnimatorUpdateListener() {
			int[] startColor = {7, 122, 1};
			int[] endColor = {9, 168, 2};
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				// —’…´Ω•±‰À„∑®
				int[] color = new int[3];
				for(int i = 0; i < color.length; i++) {
					color[i] = startColor[i] + (int) (((Float)animation.getAnimatedValue()) * (endColor[i] - startColor[i]));
				}
				mBt01.setBackgroundColor(Color.argb(255, color[0], color[1], color[2]));
			}
		});
	}
}
