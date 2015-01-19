package com.phb.draft.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class EventDemoView extends Button implements OnClickListener{
	private TextView logView;
	private StringBuilder sb = new StringBuilder();
	public EventDemoView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setOnClickListener(this);
	}

	public EventDemoView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOnClickListener(this);
	}

	public EventDemoView(Context context) {
		super(context);
		setOnClickListener(this);
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			sb.append("dispatchTouchEvent: ACTION_DOWN\n");
			break;
		case MotionEvent.ACTION_MOVE:
			sb.append("dispatchTouchEvent: ACTION_MOVE\n");
			break;
		case MotionEvent.ACTION_UP:
			sb.append("dispatchTouchEvent: ACTION_UP\n");
			break;
		case MotionEvent.ACTION_CANCEL:
			sb.append("dispatchTouchEvent: ACTION_CANCEL\n");
			break;
		default:
			break;
		}
		showLog();
		return super.dispatchTouchEvent(event);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			sb.append("onTouchEvent: ACTION_DOWN\n");
			return true;
		case MotionEvent.ACTION_MOVE:
			sb.append("onTouchEvent: ACTION_MOVE\n");
			break;
		case MotionEvent.ACTION_UP:
			sb.append("onTouchEvent: ACTION_UP\n");
			break;
		case MotionEvent.ACTION_CANCEL:
			sb.append("onTouchEvent: ACTION_CANCEL\n");
			break;
		default:
			break;
		}
		showLog();
		return super.onTouchEvent(event);
	}
	
	public void setLogView(TextView logView) {
		this.logView = logView;
	}

	@Override
	public void onClick(View v) {
		sb.append("onClick" + "\n");
		showLog();
		
	}
	
	private void showLog() {
		if(logView != null) {
			logView.setText(sb.toString());
		}
	}

}
