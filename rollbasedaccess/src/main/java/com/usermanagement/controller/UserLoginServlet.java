package com.usermanagement.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usermanagementwithjdbc.dao.UserDao;
import com.usermanagementwithjdbc.dao.UserLoginDao;
import com.usermanagementwithjdbc.dao.UserProfileDao;
import com.usermanagementwithjdbc.model.User;
import com.usermanagementwithjdbc.model.UserLoginBean;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private UserLoginDao userLoginDao;
	
		@Override
		public void init() throws ServletException {
			userLoginDao=new UserLoginDao();
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/login.jsp");
			requestDispatcher.forward(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String username=req.getParameter("username").toLowerCase();
			String password=req.getParameter("password");
			UserLoginBean userLoginBean=new UserLoginBean(username,password);
			
			RequestDispatcher requestDispatcher=null;
			
			User user=null;
			Map<Boolean, User> map=userLoginDao.validateLoginAndFetchUser(userLoginBean,req);
			Boolean isUserPresent=map.keySet().iterator().hasNext();
			
			if(isUserPresent){
				// it returns the current session if present if not create a new session and return. 
				HttpSession httpSession=req.getSession(true);
				httpSession.setAttribute("username", username);
				//httpSession.setMaxInactiveInterval(200);
				user=map.get(isUserPresent);
				String role=user.getUserRole();
				if(role.equalsIgnoreCase("ADMIN")){
					List<User> users=new UserDao().getAllUser();
					req.setAttribute("users", users);
					requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/user-list.jsp");
					requestDispatcher.forward(req, resp);
				}
				else{
					User singleUser=new UserProfileDao().getUserByUserName(username);
					req.setAttribute("user", singleUser);
					requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/user-profile.jsp");
					requestDispatcher.forward(req, resp);
				}				
			}
			else{
				req.setAttribute("message", "Credentials that provided by you is wrong !! ");
				requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/login.jsp");
				requestDispatcher.forward(req, resp);
			}
		}
}
