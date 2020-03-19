package com.quinnox.general;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Binary {

	public static void main(String[] args) {
		InputStream inputStream=null;
		OutputStream outputStream=null;
		try {
			inputStream=new FileInputStream(new File("D:\\Binary\\Upload\\1584598932687Honda.jpeg"));
			outputStream=new FileOutputStream(new File("D:\\Binary\\Local\\1584598932687Honda.jpeg"));
			
			// Now let's write this content from inputStream to outputStream
			int i=0;
    		while((i=inputStream.read())>-1){
    			outputStream.write(i);
    		}
    		System.out.println("Done");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}

	}

}
