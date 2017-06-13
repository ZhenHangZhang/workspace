package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class TestAbstract {

	public static void main(String[] args) throws IOException {
		
		File dir = new File("D:/java");
		File file1 = new File(dir, "fileTest001.txt");
		File file2 = new File(dir, "fileTest002.txt");

		if (!dir.exists()) {
			dir.mkdirs();
		}
		if (!file1.exists()) {
		file1.createNewFile();
		}
		if (!file2.exists()) {
			file2.createNewFile();
		}
        System.out.println("file1's AbsolutePath=  " + file1.getAbsolutePath());  
        System.out.println("file2's AbsolutePath=  " + file2.getAbsolutePath());  
        
        System.out.println("file1 Canread=" + file1.canRead());  
        System.out.println("file1's len= " + file1.length());  
        
        String[] fileList = dir.list(); 
        System.out.println("there are " + fileList.length + " file(s) in D:/java"); 
	readFileByChars("D:/");
	}
	
	/**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */
    public static void readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("以字符为单位读取文件内容，一次读多个字节：");
            // 一次读多个字符
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            // 读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                // 同样屏蔽掉\r不显示
                if ((charread == tempchars.length)
                        && (tempchars[tempchars.length - 1] != '\r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
	
	
}
