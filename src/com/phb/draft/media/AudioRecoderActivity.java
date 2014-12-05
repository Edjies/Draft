package com.phb.draft.media;

import com.phb.draft.R;
import com.phb.draft.animation.MInterpolator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;

public class AudioRecoderActivity extends Activity implements OnClickListener, OnTouchListener{
	// view
	private Button mBtRecode;
	private Button mBtSpeach;
	// data
	private AudioHelper audioHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_audio_recoder);
		setViews();
		setListeners();
		initData();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) 
	{
		switch (v.getId()) 
		{
		case R.id.bt_speach:
			float startX = 0;
			float startY = 0;
			TranslateAnimation tranAnim = new TranslateAnimation(startX, startX + 200, startY, startY + 200);
			tranAnim.setDuration(4000);
			tranAnim.setInterpolator(new BounceInterpolator());
			mBtSpeach.startAnimation(tranAnim);
			break;
		default:
			break;
		}
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) 
	{
		switch (v.getId()) 
		{
		case R.id.bt_recode:
			switch (event.getAction()) 
			{
			case MotionEvent.ACTION_DOWN:
				audioHelper.recordeAudio();
				break;
			case MotionEvent.ACTION_UP:
				audioHelper.stopRecorde();
			default:
				break;
			}
			break;

		default:
			break;
		}
		return false;
	}
	
	private void setViews() 
	{
		mBtRecode = (Button) findViewById(R.id.bt_recode);
		mBtSpeach = (Button) findViewById(R.id.bt_speach);
	}
	
	private void setListeners() 
	{
		mBtSpeach.setOnClickListener(this);
		mBtRecode.setOnTouchListener(this);
	}
	
	private void initData() 
	{
		audioHelper = new AudioHelper();
	}
	
}
