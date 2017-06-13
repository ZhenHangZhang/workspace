package com.inheritance;

public class Rectangle extends Graph {

	int width;
	int height;
	
	
	public Rectangle(){
		super();
		
	}
	 public Rectangle(String name) {
	        super(name);
	    }
	    
	    public Rectangle(int width, int height,String name) {
	        this(name);
	        System.out.println("My width is:" + width + "my height is :"+ height);
	    }
	    
	    public void show() {
	        super.show();
	        System.out.println("at the same time I'm a Rectangle");
	    }
	public double area(){
		return width + height;		
	}
	
	
}
