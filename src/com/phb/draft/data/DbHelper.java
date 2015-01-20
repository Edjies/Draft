package com.phb.draft.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
	public final static String db = "draft1.db";
	public final static String SQL_CREATE_TABLE = "CREATE TABLE " + TableInfo.TABLE_NAME + "("
			+ TableInfo._ID + " INTEGER PRIMARY KEY,"
			+ TableInfo._NAME + " TEXT,"
			+ TableInfo._SEX + " TEXT,"
			+ TableInfo._AGE + " INTEGER"
			+")";
	public final static String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + TableInfo.TABLE_NAME;
	public DbHelper(Context context) {
		super(context, db, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_TABLE);
		Log.i("draft", "create table");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(SQL_DELETE_TABLE);
		onCreate(db);

	}

}
