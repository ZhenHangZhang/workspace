package com.example.zhzchatview;

public class Msg {

	
	public static final int TYPE_RECEIVED = 0;
	public static final int TYPE_SEND = 1;
	private String content;



	private int type;

	public String getContent() {
		return content;
	}
	public int getType() {
		return type;
	}
 
	Msg(String content, int type){
		
		this.type = type;
		this.content = content;
		
	}

}
