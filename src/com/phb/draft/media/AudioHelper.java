package com.phb.draft.media;

import com.phb.draft.util.PerstUtil;
import android.media.MediaRecorder;
import android.text.GetChars;
import android.util.Log;
/**
 * 使用AudioHelper需要recorde_audio权限
 * 结束使用时需要调用release() 释放资源， 释放后对象不再可用
 * @author hubble
 *
 */
public class AudioHelper {
	public final static String tag = "AudioRecoderActivity";
	private MediaRecorder recorder;
	
	public AudioHelper () 
	{
		recorder = new MediaRecorder();
	}
	
	public void recordeAudio () 
	{
		try 
		{
			recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
			recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
			recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
			recorder.setOutputFile(PerstUtil.ext_dir + getAutoName());
			recorder.prepare();
			recorder.start();   // Recording is now started
		} catch (Exception e)
		{
			// 
			Log.i(tag, "MediaRecorder 初始化失败");
		}
		 
	}
	
	public void playAudio () 
	{
		
	}
	
	public void stopRecorde () 
	{
		recorder.stop();
		recorder.reset();
	}
	
	/**
	 * 当不需要再次使用时， 需要释放，此时该对象不可用于记录
	 */
	public void release () 
	{
		recorder.release();
	}
	
	private static String getAutoName ()
	{
		return "/recorde" + System.currentTimeMillis();
	}
}
