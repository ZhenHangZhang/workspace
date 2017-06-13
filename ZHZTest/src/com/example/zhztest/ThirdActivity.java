package com.example.zhztest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third_layout);
		Log.d("task", "task is" + getTaskId());

		Button button = (Button)findViewById(R.id.third_Btn);
	button.setOnClickListener(new OnClickListener() {
		
 
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			
			Intent intent = new Intent(Intent.ACTION_DIAL);
			intent.setData(Uri.parse("tel:13323819717"));
			startActivity(intent);
			
			
			
			
			
			
		}
	});
	}
	
}
