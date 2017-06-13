package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamTest {

	public static void main(String[] args) {
		
		try {
			byte bWrite [] = {10,20,30,40,50};
			
			OutputStream oStream =  new FileOutputStream("test.txt");
			for (int i = 0; i < bWrite.length; i++) {
				
				oStream.write(bWrite[i]);
			}
			oStream.close();
			
			 InputStream is = new FileInputStream("test.txt");
		      int size = is.available();
		System.out.println(is);
		      System.out.println(size);
		      for(int i = 0; i< size; i++){
		    	  System.out.println(i);
		         System.out.print((char)is.read() + "  ");
		      }
		      is.close();
			
			
			
					
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("IOException");
		}
		
		
		
	}
	
}
