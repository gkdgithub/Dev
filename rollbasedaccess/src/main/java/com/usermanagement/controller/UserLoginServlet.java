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
			Map<Integer, User> map=userLoginDao.validateLoginAndFetchUser(userLoginBean,req);
			int userCount=0;
			if(map.keySet().iterator().hasNext()){
				userCount=map.keySet().iterator().next();
			}
			
			if(userCount>0){
				System.out.println("userCount ----->>>"+userCount);
				// it returns the current session if present if not create a new session and return. 
				HttpSession httpSession=req.getSession(true);
				httpSession.setAttribute("username", username);
				//httpSession.setMaxInactiveInterval(200);
				user=map.get(userCount);
				System.out.println("User----->>>"+user);
				String role=user.getUserRole();
				System.out.println("ROLE======"+role);
				if(role.equalsIgnoreCase("ADMIN")){
					System.out.println("===Role is ADMIN===");
					List<User> users=new UserDao().getAllUser();
					req.setAttribute("users", users);
					requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/user-list.jsp");
					requestDispatcher.forward(req, resp);
				}
				else{
					System.out.println("===Role is USER===");
					User singleUser=new UserProfileDao().getUserByUserName(username);
					System.out.println("===singleUser==="+singleUser);
					req.setAttribute("singleUser", singleUser);
					requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/user-profile.jsp");
					requestDispatcher.forward(req, resp);
				}				
			}
			else{
				System.out.println("User is not present : ");
				req.setAttribute("message", "Credentials that provided by you is wrong !! ");
				requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/login.jsp");
				requestDispatcher.forward(req, resp);
			}
		}
}
