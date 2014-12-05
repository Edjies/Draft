package com.phb.draft.view;

import com.phb.draft.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * 带清除功能的EditText
 * 
 * @author Hubble
 */
public class ClearableEditText extends EditText implements TextWatcher {
	private Drawable mClearDrawable;

	public ClearableEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public ClearableEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public ClearableEditText(Context context) {
		super(context);
		init();
	}

	private void init() {
		mClearDrawable = getCompoundDrawables()[2];
		if (mClearDrawable == null) {
			mClearDrawable = getResources().getDrawable(
					R.drawable.icon_close);
		}
		mClearDrawable.setBounds(0, 0, mClearDrawable.getIntrinsicWidth(),
				mClearDrawable.getIntrinsicHeight());

		addTextChangedListener(this);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (getCompoundDrawables()[2] != null) {
			if(event.getX() > (getWidth() - getPaddingRight() - mClearDrawable.getIntrinsicWidth())
				&& (event.getX() < ((getWidth() - getPaddingRight())))) {
				if(event.getAction() == MotionEvent.ACTION_UP) {
					this.setText("");
				}
				return true;
			}
		}
		return super.onTouchEvent(event);
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int count, int after) {
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {

	}

	@Override
	public void afterTextChanged(Editable s) {
		String text = s.toString();
		if (!text.equals("")) {
			setCompoundDrawables(getCompoundDrawables()[0],
					getCompoundDrawables()[1], mClearDrawable,
					getCompoundDrawables()[3]);
		} else {
			setCompoundDrawables(getCompoundDrawables()[0],
					getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
		}
	}

}
