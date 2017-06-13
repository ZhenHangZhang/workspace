package com.ezparking.activitylifecycletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	public static final String Tag = "MainActivity";	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(Tag,"oncreate");
		Button button = (Button)findViewById(R.id.start_normal_activity);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(MainActivity.this, NormalActivity.class);
				startActivity(intent);
				
			}
		});
		Button button1 = (Button)findViewById(R.id.start_dialog_activity);
		button1.setOnClickListener(new OnClickListener() {	 
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, DialogActivity.class);
				startActivity(intent);
			}
		});
		
		
		
	}

	
	  //从stop转为激活状态时执行
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("--MainActivity--", "------onRestart--stop转为激活状态时执行----");
    }
        
    //Activity开始加载事件时执行(新创建时,或者重新启动的时候执行！)
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("--MainActivity--", "--------onStart---开始加载事件时执行-----");
    }
    
    //Activity恢复到激活状态时执行（任何一次进入激活状态都将执行）
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("--MainActivity--", "----------onResume-恢复到激活状态时执行-------------");
    }
    
    //Activity 被覆盖的时候执行
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("--MainActivity--", "-------onStop ----被覆盖的时候执行-----------");
    }
    
    //Activity 退出或者被回收时执行,仅执行一次
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("--MainActivity--","---------onDestroy---退出或者被回收时执行，仅执行一次--------------");
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
