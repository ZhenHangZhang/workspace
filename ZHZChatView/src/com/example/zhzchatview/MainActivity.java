package com.example.zhzchatview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	
	private ListView msgListView;
	private EditText inputText;
	private Button sendBtn;
	private MsgAdapter adapter;
	private List<Msg>msgList = new ArrayList<Msg>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initDatas();
		adapter = new MsgAdapter(MainActivity.this, R.layout.msg_item, msgList);
		inputText = (EditText)findViewById(R.id.input_text);
		sendBtn = (Button)findViewById(R.id.send);
		msgListView = (ListView)findViewById(R.id.msg_list_view);
		msgListView.setAdapter(adapter);
		sendBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String content = inputText.getText().toString();
				if (!content.equals("")) {
					Msg msg = new Msg(content, Msg.TYPE_SEND);
					msgList.add(msg);
					adapter.notifyDataSetChanged();
					msgListView.setSelection(msgList.size());
					inputText.setText("");					
				}
			}
		});	
	}
	private void initDatas() {
		
		Msg msg1 = new Msg("hello guy", Msg.TYPE_RECEIVED);
		msgList.add(msg1);
		Msg msg2 = new Msg("hello who is that", Msg.TYPE_SEND);
		msgList.add(msg2);

		Msg msg3 = new Msg("this is tom,nice talking to you", Msg.TYPE_RECEIVED);
		msgList.add(msg3);

		Msg msg4 = new Msg("yeah me too", Msg.TYPE_SEND);
		msgList.add(msg4);

		Msg msg5 = new Msg("what are you doing now", Msg.TYPE_RECEIVED);
		msgList.add(msg5);

		Msg msg6 = new Msg("nothing", Msg.TYPE_SEND);
		msgList.add(msg6);

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
