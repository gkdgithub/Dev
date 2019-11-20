package com.quinnox.codedb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertImageDB {
	
	public static void main(String[] args) throws SQLException {
		InsertImageDB imageTest = new InsertImageDB();
		imageTest.insertImage();
	}
 
	public Connection getConnection() {
		Connection connection = null;
 
		try {	
			// Deprecated from JDBC 4.0
			//Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaurav?useSSL=false", "root", "mysql");
		} catch (Exception e) {
			System.out.println("Error Occured While Getting the Connection: - " + e);
		}
		return connection;
	}
 
	public void insertImage() {
        Connection connection = null;
        PreparedStatement statement = null;
        FileInputStream inputStream = null;
 
        try {
            File image = new File("E:\\Honda.JPEG");
            inputStream = new FileInputStream(image);
 
            connection = getConnection();
            statement = connection.prepareStatement("insert into image_tb (image_title, image_data) values(?,?)");
            statement.setString(1, "Honda Car");
            
            // We can use either of them
            
            statement.setBlob(2,  inputStream, (image.length()));
            //statement.setBinaryStream(2,  inputStream, (image.length()));
 
            int status=statement.executeUpdate();
            
            if(status>0){
            	System.out.println("Inserted Successfully");
            }
 
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: - " + e);
        } catch (SQLException e) {
            System.out.println("SQLException: - " + e);
        } finally {
 
            try {
                connection.close();
                statement.close();
                inputStream.close();
            } catch (SQLException e) {
                System.out.println("SQLException Finally: - " + e);
            } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
}
