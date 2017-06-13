package com.customLog;

public class BlogAppException extends Exception {

	private static final long serialVersionUID = 1L;
	
	
	
	private String command ;
	
	 public BlogAppException(String command){
		 
		 this.command = command;
		 
		 
	 }
	
	public String toString(){
		
		return "Exception happened when executing command" +command;
		
	}
	
	
	
	
	
}
