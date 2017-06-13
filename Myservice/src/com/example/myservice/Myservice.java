package com.example.myservice;


import java.util.Date;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SyncRequest.Builder;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class Myservice extends Service {

	private DownloadBinder mbuilder = new DownloadBinder();
	
	class DownloadBinder extends Builder{
	
		public void startDownload() {
			Log.d("builder","startDownload");

		}
		public int getprogress() {
			Log.d("builder","getprogress");

			return 0;
		}




	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.e("server", "oncreate service");
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.e("server", "onStartCommand");
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Log.d("dingshi", "executed at " + new Date().toString());
				
			}
		}).start();
		
		AlarmManager manager = (AlarmManager)getSystemService(ALARM_SERVICE);
		int anHour = 5*1000;
		
		long triggerAttinme = SystemClock.elapsedRealtime() + anHour ;
		
		Intent intent2 = new Intent(this, AlarmReceiver.class);
		PendingIntent pIntent = PendingIntent.getBroadcast(this, 0, intent2, 0);
		manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAttinme, pIntent);
		
	 
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub

		super.onDestroy();
		Log.e("server", "onDestroy");

	}
	 

	
	
	
	

}
