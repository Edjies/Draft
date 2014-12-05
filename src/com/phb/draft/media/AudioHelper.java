package com.phb.draft.media;

import com.phb.draft.util.PerstUtil;
import android.media.MediaRecorder;
import android.text.GetChars;
import android.util.Log;
/**
 * ʹ��AudioHelper��Ҫrecorde_audioȨ��
 * ����ʹ��ʱ��Ҫ����release() �ͷ���Դ�� �ͷź�����ٿ���
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
			Log.i(tag, "MediaRecorder ��ʼ��ʧ��");
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
	 * ������Ҫ�ٴ�ʹ��ʱ�� ��Ҫ�ͷţ���ʱ�ö��󲻿����ڼ�¼
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
