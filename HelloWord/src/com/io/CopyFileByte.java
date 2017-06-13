package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileByte {
//字节流
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		
		
		
		try 
		{
			inputStream =  new FileInputStream("JC.rtf");
			outputStream = new FileOutputStream("output.txt");
			
			int c;
			while ((c = inputStream.read()) != -1) {
				
				outputStream.write(c);
				System.out.println(c);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
	         if (inputStream != null) {
	        	 try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	          if (outputStream != null) {
	        	  try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
		}

		
		
		
		
		
	}

}
