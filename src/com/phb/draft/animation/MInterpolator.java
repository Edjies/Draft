package com.phb.draft.animation;
import android.view.animation.Interpolator;
public class MInterpolator implements Interpolator{
	/**
	 * �ú�����ʱ���� ����ֵ ֮��ı�׼������ (0, 0) -> (1, 1) 
	 * @param t  
	 */
	@Override
	public float getInterpolation(float t) {
		
//		float x=2.0f*t-1.0f;
//	    return 0.5f*(x*x*x + 1.0f);
		
//		return (float) Math.cos(t);
		
		return t * t * 2;
	}


}
