package com.phb.draft;

import com.phb.draft.data.PersonalInfo;
import com.phb.draft.data.TableContract;
import com.phb.draft.view.AutoLineLayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TestActivity extends Activity implements OnClickListener{
	private EditText mEtName;
	private EditText mEtSex;
	private EditText mEtAge;
	private EditText mEtSearchName;
    private Button mBtInsert;
    private Button mBtSearch;
    private TableContract contract;
    private AutoLineLayout mAll;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		setViews();
		setListeners();
		initData();
	}
	
	private void setViews() {
		mEtName = (EditText) findViewById(R.id.et_name);
		mEtSex = (EditText) findViewById(R.id.et_sex);
		mEtAge = (EditText) findViewById(R.id.et_age);
		mEtSearchName = (EditText) findViewById(R.id.et_search_name);
		mBtInsert = (Button) findViewById(R.id.bt_insert);
		mBtSearch = (Button) findViewById(R.id.bt_search);
		mAll = (AutoLineLayout) findViewById(R.id.all);
	}
	
	private void setListeners() {
		mBtInsert.setOnClickListener(this);
		mBtSearch.setOnClickListener(this);
	}
	
	private void initData() {
		contract = new TableContract(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_search:
//			PersonalInfo info = contract.query(mEtSearchName.getText().toString());
//			mEtName.setText(info.getName());
//			mEtSex.setText(info.getSex());
//			mEtAge.setText(info.getAge() + "");
			mAll.addTags(mEtSearchName.getText().toString());
			break;
		case R.id.bt_insert:
			//contract.insert(mEtName.getText().toString(), mEtSex.getText().toString(), Integer.valueOf(mEtAge.getText().toString()));
			mAll.addTags(mEtSearchName.getText().toString());
			break;
		default:
			break;
		}
		
	}
	
	
	
}
