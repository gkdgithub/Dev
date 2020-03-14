package com.quinnox.codedb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetriveImageDB2 {
	
	public static void main(String[] args) throws SQLException {
		RetriveImageDB2 imageTest = new RetriveImageDB2();
		imageTest.retriveImage();
	}
 
	public Connection getConnection() {
		Connection connection = null;
 
		try {
			/*From JDBC 4.0, we don't need to include 'Class.forName()' in our code to load JDBC driver. 
			JDBC 4.0 drivers that are found in your classpath are automatically loaded.*/
			//Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaurav?useSSL=false", "root", "mysql");
		} catch (Exception e) {
			System.out.println("Error Occured While Getting the Connection: - " + e);
		}
		return connection;
	}
 
	public void retriveImage() {
        Connection connection = null;
        PreparedStatement statement = null;
        FileOutputStream outputStream = null;
        InputStream inputStream=null;
 
        try {
            connection = getConnection();
            statement = connection.prepareStatement("select image_data from image_tb LIMIT 1");
            ResultSet rs=statement.executeQuery();
            
            if(rs!=null){
            	while(rs.next()){
            		Blob imageBlob=rs.getBlob("image_data");
            		// Retrive image data by getBinaryStream into inputStream
            		inputStream=imageBlob.getBinaryStream(1, imageBlob.length());
            		outputStream=new FileOutputStream(new File("D:\\Binary\\Retrive\\Honda.jpeg"));
            		
            		// Now let's write this content from inputStream to outputStream
            		int i=0;
            		while((i=inputStream.read())>-1){
            			outputStream.write(i);
            		}
            		
            	}
            	System.out.println("Image Retrived");
            }
            
 
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: - " + e);
        } catch (SQLException e) {
            System.out.println("SQLException: - " + e);
        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
 
            try {
            	 inputStream.close();
            	 outputStream.flush();
                 outputStream.close();
                 statement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("SQLException Finally: - " + e);
            } catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
		
}
