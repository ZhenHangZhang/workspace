package com.example.databasetest;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class MainActivity extends Activity {

	private MyDatabaseHelper dbhelper;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dbhelper = new MyDatabaseHelper(MainActivity.this, "BookStore.db", null, 2);
		Button createBtn = (Button)findViewById(R.id.create_dataBase);
		createBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			SQLiteDatabase db =	dbhelper.getWritableDatabase();
				
//			 ContentValues values = new ContentValues();
//			 values.put("className", classInfo.getName());
//			 values.put("studentId", student.getStudentId());
//			 values.put("classId", classInfo.getId());
//			 db.insert("Class", null, values);
//			 
//			 ContentValues values1 = new ContentValues();
//			 values1.put("studentId", student.getStudentId());
//			 values1.put("name", student.getName());
//			 values1.put("classId", classInfo.getId());
//			 db.insert("Student", null, values1);
//			 db.close();
				
				
			}
		});
		
		Button checkBtn = (Button)findViewById(R.id.check_dataBase);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
