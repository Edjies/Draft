package com.phb.draft.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;

public class TextDrawable extends ShapeDrawable {
	private String text;
    private Paint paint;
    
    public TextDrawable(String text) {
    	this.text = text;
    }
    
	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
	    this.paint = getPaint();
	    paint.setColor(Color.WHITE);
	    paint.setTextSize(22f);
	    paint.setAntiAlias(true);
	    paint.setFakeBoldText(true);
	    paint.setShadowLayer(6f, 0, 0, Color.BLACK);
	    paint.setStyle(Paint.Style.FILL);
	    paint.setTextAlign(Paint.Align.LEFT);
	    canvas.drawText(text, 0, 0, paint);

	}

	@Override
	public void setAlpha(int alpha) {
		super.setAlpha(alpha);

	}

	@Override
	public void setColorFilter(ColorFilter cf) {
		super.setColorFilter(cf);

	}

	@Override
	public int getOpacity() {
		return super.getOpacity();
	}
}
