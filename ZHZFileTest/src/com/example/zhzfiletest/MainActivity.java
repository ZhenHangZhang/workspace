package com.example.zhzfiletest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.w3c.dom.Text;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	private EditText textLabel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textLabel = (EditText)findViewById(R.id.data);
		
		Button saveBtn = (Button)findViewById(R.id.save);
		
		saveBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String content111 = textLabel.getText().toString();
				if (content111.length()>0) {
				
					FileOutputStream outputStream = null;
					BufferedWriter writer = null;
					
				try {
					
					outputStream = openFileOutput("data", Context.MODE_PRIVATE);
					
					writer = new BufferedWriter(new OutputStreamWriter(outputStream));
					writer.write(content111);
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					
					
					try {
						
						if (writer != null) {
							writer.close();
							textLabel.setText("");
						}
						
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();

					}
					
				}
					
					
					
				}else {
					show("shu ru nei tong wei kong ");
				}
				
				
			}
		});
		
		
		Button readBtn = (Button)findViewById(R.id.read);
		readBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				SharedPreferences.Editor editor = getSharedPreferences("zhz", MODE_PRIVATE).edit();
				editor.putString("z", "zhang");
				editor.putBoolean("h", false);
				
				editor.commit();
				
//				String dataStr = read("data");
//			
//				if (!TextUtils.isEmpty(dataStr)) {
//					
//					textLabel.setText(dataStr);
//					textLabel.setSelection(dataStr.length());
//					show("read success");
//				}	
			}
		});
		
		
		Button shareBtn = (Button)findViewById(R.id.prederence);
		shareBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences preferences = getSharedPreferences("zhz", MODE_PRIVATE);				
				
			}
		});
		

	}
	
	private String read(String string) {
		
	FileInputStream inputStream = null;
	BufferedReader reader = null;
	
	StringBuilder content = new StringBuilder();
	
	try {
		
		inputStream = openFileInput(string);
		reader = new BufferedReader(new InputStreamReader(inputStream));
		String line = "";
		while ((line = reader.readLine()) != null) {
			content.append(line);
		}
				
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		try {
			
			if (reader != null) {
				
				reader.close();
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	
	
		
		return content.toString();
	}
	
	private void show(String string) {
		
		
		Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
		
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
