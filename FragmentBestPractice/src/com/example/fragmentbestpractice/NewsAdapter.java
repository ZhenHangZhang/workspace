package com.example.fragmentbestpractice;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NewsAdapter extends ArrayAdapter<News> {

	private int resourid ;
	public NewsAdapter(Context context, int textViewResourceId, List<News> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		resourid = textViewResourceId;
	}	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		News news = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourid, null);
			viewHolder = new ViewHolder();
			viewHolder.teView = (TextView)view.findViewById(R.id.news_title);
			view.setTag(viewHolder);
		}else {
			view = convertView;
			viewHolder = (ViewHolder)view.getTag();
		}
		viewHolder.teView.setText(news.getTitle());		
		return view;
	}
	
	class ViewHolder {
		
		TextView teView;
		
	}
	
	
}
