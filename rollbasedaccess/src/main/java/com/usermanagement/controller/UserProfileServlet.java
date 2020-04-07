package com.usermanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanagementwithjdbc.dao.UserProfileDao;
import com.usermanagementwithjdbc.model.User;

@WebServlet("/ProfileServlet")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserProfileServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("username");
		System.out.println("USERNAME ===>>> "+userName);
		UserProfileDao userProfileDao=new UserProfileDao();
		User user=userProfileDao.getUserByUserName(userName);
		request.setAttribute("user", user);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/pages/user-profile.jsp");
		requestDispatcher.forward(request, response);
	}
}
