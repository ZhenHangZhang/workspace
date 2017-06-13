package com.example.zhzcustomviews;

import android.R.raw;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class TitleLayouy extends LinearLayout {

	
	public TitleLayouy(Context context,AttributeSet attributeSet) {
		// TODO Auto-generated constructor stub
		super(context, attributeSet);
		LayoutInflater.from(context).inflate(R.layout.title_layout_nav, this);
		
		
		Button backBtn = (Button)findViewById(R.id.button1);
		backBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				((Activity)getContext()).finish();
				
			}
		});
		
	}
	
}
