package com.usermanagementwithjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.usermanagementwithjdbc.model.User;
import com.usermanagementwithjdbc.model.UserLoginBean;
import com.usermanagementwithjdbc.util.DbConnection;

public class UserLoginDao {
		
	private static final String SELECT_BY_USERNAME_PASSWORD="select * from user_table where userName=? and password=?";
	
	public UserLoginDao() {
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection(){
		return new DbConnection().getConnection();
	}
	
	public Map<Boolean,User> validateLoginAndFetchUser(UserLoginBean userLoginBean,HttpServletRequest req){
		Connection connection=getConnection();
		boolean status=false;
		User user=new User();
		Map<Boolean,User> map=new HashMap<>();
		
		try(PreparedStatement preparedStatement=connection.prepareStatement(SELECT_BY_USERNAME_PASSWORD)){
			preparedStatement.setString(1, userLoginBean.getUserName());
			preparedStatement.setString(2, userLoginBean.getPassword());
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()){
				System.out.println("Rs is not null");
				String password=rs.getString("password");
				if(password.equals(userLoginBean.getPassword())){
					//System.out.println(rs.getString("userRole"));
					HttpSession httpSession=req.getSession();
					httpSession.setAttribute("ROLE", rs.getString("userRole"));
					
					user.setId(rs.getInt("id"));
					user.setUserName(rs.getString("userName"));
					user.setEmail(rs.getString("email"));
					user.setCountry(rs.getString("country"));
					
					status=true;
				}			
			}
			else{
				System.out.println("Rs is null");
				//status=false;
			}			
		}
		catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
		map.put(status, user);
		return map;	
	}

	
}
