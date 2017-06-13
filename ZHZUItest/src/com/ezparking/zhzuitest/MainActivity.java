package com.ezparking.zhzuitest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public  class MainActivity extends Activity implements OnClickListener  {
	
	private TextView textV;
	private Button btn;
	private ProgressBar press;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		setUpT();
		btn = (Button)findViewById(R.id.button1);
		press = (ProgressBar)findViewById(R.id.press);
		btn.setOnClickListener(this);
	}

	private void setUpT() {
		textV = (TextView)findViewById(R.id.text_zhz);
		textV.setAlpha(0);

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
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		switch (v.getId()) {
		case R.id.button1:
			
//			int progress = press.getProgress();
//			progress = progress +10;
//			press.setProgress(progress);
			
//			if (press.getVisibility() == View.GONE) {
//				press.setVisibility(View.VISIBLE);
//			}else {
//				press.setVisibility(View.GONE);
//			}
			
			
			AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
			
			dialog.setTitle("this is a dialog");
			dialog.setMessage("something is important");
			dialog.setCancelable(false);
			dialog.setPositiveButton("ok", new  DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.e("", dialog.toString() + which);

				}
			}); 
			
			dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.e("", dialog.toString() + which);
				}
			});
			dialog.show();
			break;
		default:
			break;
		}
	}
}
