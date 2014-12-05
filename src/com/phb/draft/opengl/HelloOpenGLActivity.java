package com.phb.draft.opengl;

import android.app.Activity;
import android.os.Bundle;

public class HelloOpenGLActivity extends Activity {
	private HelloGLSurfaceView mGLview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mGLview = new HelloGLSurfaceView(this);	// 实例化 GLSurfaceView
		mGLview.setRenderer(new HelloRender()); // 为GLSurfaceView设置渲染器
		setContentView(mGLview);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		mGLview.onResume();						// 必须调用 GLSurfaceView 的 onResume() 方法
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		mGLview.onPause();						// 必须调用 GLSurfaceView 的 onPause() 方法
	}
}
