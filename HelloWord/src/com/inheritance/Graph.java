package com.inheritance;

public abstract class Graph {

	   String name;
	    
	    public Graph(){}
	    
	    public Graph(String name) {
	        this.name = name;
	    }
	    
	    public void show() {
	        System.out.println("I'm a graph");
	    }
	    
	    public abstract double area() ;
	
}
