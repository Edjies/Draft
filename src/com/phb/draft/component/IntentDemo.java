package com.phb.draft.component;

import com.phb.draft.R;
import com.phb.draft.R.layout;
import com.phb.draft.R.menu;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class IntentDemo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_demo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.intent_demo, menu);
		return true;
	}
	
	public void doClick(View view) {
		switch(view.getId()) {
		case R.id.bt_sms:
			Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:10086"));
			intent.putExtra("sms_body", "10086");    
			startActivity(intent);
			break;
		case R.id.bt_pi_notify_receiver:break;
		case R.id.bt_pi_widget_activity:break;
		case R.id.bt_pi_alarm_service:break;
		}
	}
}
