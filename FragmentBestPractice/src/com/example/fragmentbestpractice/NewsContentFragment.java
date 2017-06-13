package com.example.fragmentbestpractice;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewsContentFragment extends Fragment {

	private View view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.news_content_frag, container,false);		
		return view;
	}
	
	public void refresh(String newsTitle,String newsContent) {
		
		View visibilituLayout = view.findViewById(R.id.visibility_layout);
		visibilituLayout.setVisibility(View.VISIBLE);
		TextView title = (TextView)view.findViewById(R.id.news_title);
		title.setText(newsTitle); 
		TextView content = (TextView)view.findViewById(R.id.news_content);
		content.setText(newsContent); 

	}
	
	
	
}
