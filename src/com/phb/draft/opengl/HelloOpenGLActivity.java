package com.phb.draft.opengl;

import android.app.Activity;
import android.os.Bundle;

public class HelloOpenGLActivity extends Activity {
	private HelloGLSurfaceView mGLview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mGLview = new HelloGLSurfaceView(this);	// ʵ���� GLSurfaceView
		mGLview.setRenderer(new HelloRender()); // ΪGLSurfaceView������Ⱦ��
		setContentView(mGLview);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		mGLview.onResume();						// ������� GLSurfaceView �� onResume() ����
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		mGLview.onPause();						// ������� GLSurfaceView �� onPause() ����
	}
}
