package com.example.broadcastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;import android.content.DialogInterface;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;

public class ForceOfflineBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, Intent intent) {
		// TODO Auto-generated method stub

		
	AlertDialog.Builder dialog = new AlertDialog.Builder(context);
	dialog.setTitle("提示");
	dialog.setMessage("您的账号在别处登陆，请重新登陆");
	dialog.setCancelable(false);
	dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			ActivityController.finishAll();
			Intent intent = new Intent(context, LoginActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intent);

		}
	});	
	AlertDialog dialog2 = dialog.create();
	dialog2.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
	dialog2.show();
	
	}

}
