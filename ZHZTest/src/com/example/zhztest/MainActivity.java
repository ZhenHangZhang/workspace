package com.example.zhztest;




import android.R.string;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
 
import android.widget.Button;
 
import android.widget.Toast;
 
public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (savedInstanceState != null) {
			String tempStr = savedInstanceState.getString("data_key");
			Log.d("data_key", tempStr);
			
		}
		Log.i("task:++++", "task id is"+ getTaskId());
        Log.i("--MainActivity--","--------onCreate- 系统自动初始化---------");
		
		Button button = (Button) findViewById(R.id.button1);
 
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String data = "zhanghangzhen";

				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//				Intent intent = new Intent("com.example.zhztest.ACTION_START");
				
//				Intent intent = new Intent(Intent.ACTION_VIEW);
//				intent.setData(Uri.parse("http://www.baidu.com"));
				intent.putExtra("zhz", data);
				
				
				startActivityForResult(intent, 1);
//				startActivity(intent);

			}
		});
		
	}
	//启动活动的方法。，，
	public static void actionStart(Context context,String data1,String data2){
		
		Intent intent = new Intent(context,SecondActivity.class);
		
		intent.putExtra("prama1", data1);
		intent.putExtra("prama2", data2);
		context.startActivity(intent);

		
		
		
	}
	
	
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		
		String tempData = "something you just tryed";
		outState.putString("data_key", tempData);
		
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
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		switch (requestCode) {
		case 1:
			if (resultCode == RESULT_OK) {
				
				String string = data.getStringExtra("reture_sec");
				Log.d("reture:", string);
				
			}
			break;

		default:
			break;
		}
		
		
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
	switch (item.getItemId()) {
	case R.id.add_item:
		
		Toast.makeText(MainActivity.this, "add+test", 2).show();
		
		break;
	case R.id.remove_item:
		
		Toast.makeText(MainActivity.this, "remove+test", 2).show();
		
		break;

	default:
		break;
	}
		return super.onOptionsItemSelected(item);
	}
	
	
	
	
	
	
}
