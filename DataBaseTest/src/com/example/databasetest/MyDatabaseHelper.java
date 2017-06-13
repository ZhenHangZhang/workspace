package com.example.databasetest;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

	private Context mContext;
	
	
	public static final String CREATE_BOOK = "create table Book("
			+ "id integer primary key autoincrement, "
			+ "author text, "
			+ "price real, "
			+ "pages integer, "
			+ "name text) ";
	
	public static final String CREATE_GATEGORY = "create table Category ("
	        + "id integer primary key autoincrement, "
			+ "category_name text, "
	        + "category_code integer)";
			
	
	
	public MyDatabaseHelper(Context context, String name, CursorFactory factory, int version ) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_BOOK);
		db.execSQL(CREATE_GATEGORY);
		Toast.makeText(mContext, "create success",Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists Book");
		
		db.execSQL("drop table if exists Category");

		onCreate(db);
	}

}
