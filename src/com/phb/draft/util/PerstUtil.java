package com.phb.draft.util;

import java.io.File;

import android.os.Environment;

public class PerstUtil {
	public final static String ext_dir = Environment.getExternalStorageDirectory() + "/draft"; 
	
	static 
	{
		File file = new File(ext_dir);
		if( !file.exists() || !file.isDirectory() )
		{
			file.mkdir();
		}
	}
}
