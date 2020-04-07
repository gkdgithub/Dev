package com.usermanagementwithjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.usermanagementwithjdbc.model.User;
import com.usermanagementwithjdbc.util.DbConnection;

public class UserProfileDao {
	
	
	private static final String SELECT_PROFILE_BY_USERNAME="select * from user_table where userName=?";
	private static final String VERIFY_PASSWORD="select password from user_table where userName=?";
	private static final String UPDATE_PASSWORD="update user_table set password=? where userName=?";
	
	
	public UserProfileDao() {
		
	}
	
	public Connection getConnection(){
		return new DbConnection().getConnection();
	}
	
	public User getUserByUserName(String userName){
		System.out.println("Inside getUserByUserName of userProfile class, userName --===>>>"+userName);
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
					user.setUserRole(rs.getString("userRole"));
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
	
	public Boolean verifyOldPassword(String oldPassword, String username){
		System.out.println("===verifyOldPassword===");
		boolean isPresent=false;
		try(PreparedStatement preparedStatement=getConnection().prepareStatement(VERIFY_PASSWORD)){
			preparedStatement.setString(1, username);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()){
				if(oldPassword.equals(rs.getString("password"))){
					System.out.println("===OldPassword is Present===");
					isPresent=true;
				}
				else{
					System.out.println("===OldPassword is not Present===");
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isPresent;
	}
	
	public int changePassword(String oldPassword, String enterNewPassword, String username) {
		int updated=0;
		try(PreparedStatement preparedStatement=getConnection().prepareStatement(UPDATE_PASSWORD)){
			preparedStatement.setString(1, enterNewPassword);
			preparedStatement.setString(2, username);
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
