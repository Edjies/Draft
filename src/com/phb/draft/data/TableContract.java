package com.phb.draft.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TableContract {
	private DbHelper helper;
	public TableContract(Context context) {
		helper = new DbHelper(context);
	}
	
	public void insert(String name, String sex, int age) {
		SQLiteDatabase db = null;
		try {
			db = helper.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put(TableInfo._NAME, name);
			values.put(TableInfo._SEX, sex);
			values.put(TableInfo._AGE, age);
			db.insert(TableInfo.TABLE_NAME, null, values);
		}finally{
			if(db != null) {
				db.close();
			}
		}
		
	}
	
	public PersonalInfo query(String name) {
		SQLiteDatabase db = null;
		Cursor c = null;
		PersonalInfo info = null;
		try {
			
			db = helper.getReadableDatabase();
			String[] projection = {TableInfo._NAME, TableInfo._SEX, TableInfo._AGE};
//			String sortOrder = TableInfo._AGE + "DESC";
			String selection = TableInfo._NAME + " = ?";
			String[] selectionArgs = {name};
			c = db.query(TableInfo.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
			if(c.moveToFirst()) {
				info = new PersonalInfo();
				info.setName(c.getString(c.getColumnIndex(TableInfo._NAME)));
				info.setSex(c.getString(c.getColumnIndex(TableInfo._SEX)));
				info.setAge(c.getInt(c.getColumnIndex(TableInfo._AGE)));
			}
			return info;
		}finally{
			if(c != null) {
				c.close();
			}
			if(db != null) {
				db.close();
			}
		}
	}
}
