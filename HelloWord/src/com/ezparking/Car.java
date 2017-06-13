package com.ezparking;

public class Car {


	String title;
	private Engine engine;
	
	public int color ;
	int speed ;
	
 public  Car(int color , String  title) {
	
	 this.color = color;
	 this.title = title;
	 
	
	 
}
	
	

	
	public void startUp(){
		run(1810);
		System.out.println("qidong");
		System.out.println(this.title);
	}
	
	void run(int speed){
		
		engine =  new Engine();
		System.out.println(engine);
		System.out.println("我的速度是"+ speed);
	}
	
} 
