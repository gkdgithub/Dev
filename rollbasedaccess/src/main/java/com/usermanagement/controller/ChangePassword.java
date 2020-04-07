package com.usermanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usermanagementwithjdbc.dao.UserDao;
import com.usermanagementwithjdbc.dao.UserProfileDao;
import com.usermanagementwithjdbc.model.User;
import com.usermanagementwithjdbc.util.CheckPasswordStrength;

@WebServlet("/changePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ChangePassword() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession=request.getSession(true);
		String userName=(String) httpSession.getAttribute("username");
		if(userName==null){
			try {
				request.setAttribute("loginMessage", "You need to do login first !! ");
				request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		else{
			request.getRequestDispatcher("WEB-INF/pages/change-password.jsp").forward(request, response);
		}		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession=request.getSession(true);
		String username=(String)httpSession.getAttribute("username");
		
		String sessionRole=(String)httpSession.getAttribute("ROLE");
		
		String oldPassword=request.getParameter("oldPassword");
		String enterNewPassword=request.getParameter("EnterNewPassword");
		String reEnterNewPassword=request.getParameter("ReEnterNewPassword");
		String password="";
		if(new UserProfileDao().verifyOldPassword(oldPassword, username)){
			System.out.println("===Old password is correct===");
			if(CheckPasswordStrength.calculatePasswordStrenth(enterNewPassword)){
				
				if(enterNewPassword.equals(reEnterNewPassword)){
					int updated=new UserProfileDao().changePassword(oldPassword, enterNewPassword,username);
					if(updated>0){
						if(sessionRole.equalsIgnoreCase("USER")){
							String passwordChanged="Password changed succesfully ! ";
							request.setAttribute("passwordChanged", passwordChanged);
							User singleUser=new UserProfileDao().getUserByUserName(username);
							request.setAttribute("singleUser", singleUser);
							request.getRequestDispatcher("WEB-INF/pages/user-profile.jsp").forward(request, response);
						}
						else{
							String passwordChanged="Password changed succesfully ! ";
							request.setAttribute("passwordChanged", passwordChanged);
							request.setAttribute("users", new UserDao().getAllUser());
							request.getRequestDispatcher("WEB-INF/pages/user-list.jsp").forward(request, response);
						}
					}
				}
				else{
					password="Your new Password is not matching !";
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
		else{
			password="Your old Password is not correct !";
			request.setAttribute("password", password);
			try {request.getRequestDispatcher("WEB-INF/pages/change-password.jsp").forward(request, response);} 
			catch (ServletException | IOException e) {e.printStackTrace();}
		}
		
	}

}
