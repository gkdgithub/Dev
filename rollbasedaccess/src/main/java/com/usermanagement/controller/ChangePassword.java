package com.usermanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanagementwithjdbc.dao.UserProfileDao;
import com.usermanagementwithjdbc.util.CheckPasswordStrength;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ChangePassword() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/change-password.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String oldPassword=request.getParameter("oldPassword");
		String enterNewPassword=request.getParameter("EnterNewPassword");
		String reEnterNewPassword=request.getParameter("ReEnterNewPassword");
		String password="";
		if(CheckPasswordStrength.calculatePasswordStrenth(enterNewPassword)){
			if(enterNewPassword.equals(reEnterNewPassword)){
				int updated=new UserProfileDao().changePassword(oldPassword, enterNewPassword);
				if(updated>0){
					String passwordChanged="Password changed succesfully ! ";
					request.setAttribute("passwordChanged", passwordChanged);
					request.getRequestDispatcher("WEB-INF/pages/user-profile.jsp").forward(request, response);
				}
			}
			else{
				password="Your Password is not matching !";
				request.setAttribute("password", password);
				try {request.getRequestDispatcher("WEB-INF/pages/change-password.jsp").forward(request, response);} 
				catch (ServletException | IOException e) {e.printStackTrace();}
			}
		}
		else{
			password="Your Password is not strong enough !";
			request.setAttribute("password", password);
			try {request.getRequestDispatcher("WEB-INF/pages/change-password.jsp").forward(request, response);} 
			catch (ServletException | IOException e) {e.printStackTrace();}
		}
		
	}

}
