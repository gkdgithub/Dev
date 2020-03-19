package com.quinnox.fileUpload.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.io.ByteArrayOutputStream;


import com.quinnox.fileUpload.model.Image;

public class FileUploadDao {
	
 	private static String URL = "jdbc:mysql://localhost:3306/fileappdb3?useSSL=false";
 	private static String USER = "root";
 	private static String PASSWORD = "mysql";
	
	public Boolean saveFileToDB(String fileName, String fileSavePath) {
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			String sqlQuery = "INSERT INTO upload_filepath (fileName, filePath) values (?, ?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, fileName);
			preparedStatement.setString(2, fileSavePath);
			
			if(preparedStatement.executeUpdate()>0){
				status=true;
			}
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return status;	
	}
	
	public Image getFile(){
		String fileName=null;
		String filePath=null;
		InputStream inputStream=null;
		OutputStream outputStream=null;
		Image image=new Image();
		try {
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			String sqlQuery = "select * from upload_filepath";
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs!=null){
				if(rs.next()){
					fileName=rs.getString("fileName");
					filePath=rs.getString("filePath");
				}			
			}
			System.out.println("Path : "+filePath);
			inputStream=new FileInputStream(new File(filePath));
			outputStream=new ByteArrayOutputStream();
			int i=0;
    		while((i=inputStream.read())>-1){
    			outputStream.write(i);
    		}
			/*byte[] buffer = new byte[4096];
            int bytesRead = -1;
             
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);                  
            }*/
    		String imageToString=Base64.getEncoder().encodeToString(outputStream.toString().getBytes());
    		//String imageToString=outputStream.toString();
    		//String imageToString=new String(outputStream.toString().getBytes(),"UTF-8");
    		image.setFileName(fileName);
    		image.setBase64Image(imageToString);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return image;
	}

}
