package com.usermanagementwithjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.usermanagementwithjdbc.model.User;
import com.usermanagementwithjdbc.util.DbConnection;

public class UserProfileDao {
	
	
	private static final String SELECT_PROFILE_BY_USERNAME="select * from user_table where userName=?";
	private static final String UPDATE_PASSWORD="update user_table set password=? where password=?";
	
	
	public UserProfileDao() {
		
	}
	
	public Connection getConnection(){
		return new DbConnection().getConnection();
	}
	
	public User getUserByUserName(String userName){
		System.out.println(userName);
		User user=new User();
		ResultSet rs=null;
		PreparedStatement pStatement=null;
		try {
			pStatement=getConnection().prepareStatement(SELECT_PROFILE_BY_USERNAME);
			pStatement.setString(1, userName);
			rs=pStatement.executeQuery();
				if(rs.next()){
					user.setId(rs.getInt("id"));
					user.setUserName(rs.getString("userName"));
					user.setEmail(rs.getString("email"));
					user.setCountry(rs.getString("country"));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				pStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;	
	}

	
	public int changePassword(String oldPassword, String enterNewPassword) {
		int updated=0;
		try(PreparedStatement preparedStatement=getConnection().prepareStatement(UPDATE_PASSWORD)){
			preparedStatement.setString(1, enterNewPassword);
			preparedStatement.setString(2, oldPassword);
			updated=preparedStatement.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return updated;			
	}
	
}
