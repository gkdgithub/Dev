package com.quinnox.codedb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcWriteImage {

    public static void main(String[] args) {

        String cs = "jdbc:mysql://localhost:3306/gaurav?useSSL=false";
        String user = "root";
        String password = "mysql";

        String sql = "insert into image_tb (image_title, image_data) values(?,?)";

        try (Connection con = DriverManager.getConnection(cs, user, password); PreparedStatement pst = con.prepareStatement(sql)) {

            File myFile = new File("E:\\Honda.JPEG");
            try (FileInputStream fin = new FileInputStream(myFile)) {
            	
            	pst.setString(1, "Honda Car");
                pst.setBinaryStream(2, fin, (int) myFile.length());
                int status=pst.executeUpdate();
                
                if(status>0){
                	System.out.println("Inserted Successfully");
                }

            } catch (IOException ex) {

                Logger lgr = Logger.getLogger(JdbcWriteImage.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JdbcWriteImage.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
