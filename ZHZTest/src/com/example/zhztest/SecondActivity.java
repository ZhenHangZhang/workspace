package com.example.zhztest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class SecondActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		
		Log.d("task", "task is" + getTaskId());
        Log.i("--SecondActivity--","--------onCreate- 系统自动初始化---------");	
        Intent intent = getIntent();
	    String data = intent.getStringExtra("zhz");
 	Log.d("sec", data);
		 
		
		Button button1 = (Button)findViewById(R.id.second_btn);
		button1.setText("返回");
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent inte = new Intent(SecondActivity.this, ThirdActivity.class);
				startActivity(inte);
				
				
//				backToMainActivitu();
			}
		});
	}
	
	 //从stop转为激活状态时执行
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("--SecondActivity--", "------onRestart--stop转为激活状态时执行----");
    }
        
    //Activity开始加载事件时执行(新创建时,或者重新启动的时候执行！)
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("--SecondActivity--", "--------onStart---开始加载事件时执行-----");
    }
    
    //Activity恢复到激活状态时执行（任何一次进入激活状态都将执行）
    @Override
    protected void onResume() {
        super.onResume();
       
        Log.i("--SecondActivity--", "----------onResume-恢复到激活状态时执行-------------");
    }
    
    //Activity 被覆盖的时候执行
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("--SecondActivity--", "-------onStop ----被覆盖的时候执行-----------");
    }
    
    //Activity 退出或者被回收时执行,仅执行一次
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("--SecondActivity--","---------onDestroy---退出或者被回收时执行，仅执行一次--------------");
    }
	
	
	private void backToMainActivitu() {
		Intent intent = new Intent();
		intent.putExtra("reture_sec", "zhz_zhz_test");
		setResult(RESULT_OK, intent);
		
		finish();
		
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		backToMainActivitu();
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		backToMainActivitu();

	}
	
	
}
