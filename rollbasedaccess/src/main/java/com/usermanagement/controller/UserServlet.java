package com.usermanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/")
public class UserServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		userDao=new UserDao();
	}
   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionPath=req.getServletPath();
		switch(actionPath){
		case "/new":
			showNewForm(req,resp);
			break;
		case "/insert":
			insertUser(req,resp);
			break;
		case "/update":
			updateUser(req,resp);
			break;
		case "/edit":
			showEditForm(req,resp);
			break;
		case "/delete":
			deleteUser(req,resp);
			break;
		case "/list":
			listUser(req,resp);
			break;
		default:
			showNewForm(req,resp);
		}
	}
	
	private void showNewForm(HttpServletRequest req, HttpServletResponse resp) {
		
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/user-form.jsp");
		try {
			requestDispatcher.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void insertUser(HttpServletRequest req, HttpServletResponse resp) {
		String password=null;
		if(CheckPasswordStrength.calculatePasswordStrenth(req.getParameter("password"))){
			System.out.println("Coming inside Password Checker");
			String userName=req.getParameter("username").toLowerCase();
			System.out.println("userName--->>>"+userName);
			boolean existingUserName=userDao.checkDuplicateUserName(userName);
			System.out.println("existingUserName :: "+existingUserName);
			if(existingUserName){
				System.out.println("UserName already exist Try another");
				userName="UserName already exist Try another !";
				req.setAttribute("userName", userName);
				try {req.getRequestDispatcher("WEB-INF/pages/user-form.jsp").forward(req, resp);} 
				catch (ServletException | IOException e) {e.printStackTrace();}
			}
			else{
				System.out.println("UserName does not exist");
				password=req.getParameter("password");
				String userEmail=req.getParameter("email").toLowerCase();
				String userCountry=req.getParameter("country");
				// By Default EveryOne is normal User
				String userRole="USER";
				
				User user=new User();
				user.setUserName(userName);
				user.setPassword(password);
				user.setEmail(userEmail);
				user.setCountry(userCountry);
				user.setUserRole(userRole);
			
				userDao.saveUser(user);
				
				try {
					System.out.println("====Inside try===");
					//resp.sendRedirect("WEB-INF/pages/user-form.jsp");
					String regisMessage="Registration Successful";
					req.setAttribute("regisMessage", regisMessage);
					req.getRequestDispatcher("WEB-INF/pages/user-form.jsp").forward(req, resp);					
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
			
		}else{
			password="Your Pass is not strong enough !";
			req.setAttribute("password", password);
			try {req.getRequestDispatcher("WEB-INF/pages/user-form.jsp").forward(req, resp);} 
			catch (ServletException | IOException e) {e.printStackTrace();}
		}

	}
	
	private void listUser(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession httpSession=req.getSession(true);
		String userName=(String) httpSession.getAttribute("username");
		
		System.out.println("userName from list all user method : " + userName);
		
		if(userName!=null){
			User singleUser=new UserProfileDao().getUserByUserName(userName);
			System.out.println("singleUser==>>>>>>"+singleUser);
			if(singleUser.getUserRole().equalsIgnoreCase("USER")){
				req.setAttribute("singleUser", singleUser);
				try {
					req.getRequestDispatcher("WEB-INF/pages/user-profile.jsp").forward(req, resp);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
			else{
				List<User> users=userDao.getAllUser();
				req.setAttribute("users", users);
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/user-list.jsp");
				try {
					requestDispatcher.forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else{
			try {
				req.setAttribute("loginMessage", "You need to do login first !! ");
				req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession httpSession=req.getSession(true);
		String userName=(String) httpSession.getAttribute("username");
		
		if(userName==null){
			try {
				req.setAttribute("loginMessage", "You need to do login first !! ");
				req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		else{
			int id=Integer.parseInt(req.getParameter("id"));
			String sessionRole=(String)httpSession.getAttribute("ROLE");
			
			if(("ADMIN".equalsIgnoreCase(sessionRole))){
				userDao.deleteUser(id);
				try {
					resp.sendRedirect("list");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else{
				userDao.deleteUser(id);
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("/logout");
				try {
					requestDispatcher.forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} // end of else
		
	}

	private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
		
			HttpSession httpSession=req.getSession(true);
			String userName=(String) httpSession.getAttribute("username");
			RequestDispatcher requestDispatcher=null;
			
			if(userName!=null){
				int id=Integer.parseInt(req.getParameter("id"));
				User existingUser=userDao.getUser(id);
				
				req.setAttribute("user", existingUser);
				requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/edit-userForm.jsp");
				try {
					System.out.println("Inside try block =========");
					requestDispatcher.forward(req, resp);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
				
			} // end of if
			else{
				//System.out.println("else part");
				req.setAttribute("loginMessage", "You need to do login first !! ");
				requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/login.jsp");
				try {
					requestDispatcher.forward(req, resp);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			} // end of else
			

	}

	private void updateUser(HttpServletRequest req, HttpServletResponse resp) {
		
			int id=Integer.parseInt(req.getParameter("id"));
			String userEmail=req.getParameter("email");
			String userCountry=req.getParameter("country");
			
			String userName=req.getParameter("userName").toLowerCase();
			System.out.println("userName--->>>"+userName);
			boolean existingUserName = userDao.checkDuplicateUserName(userName);
			System.out.println("existingUserName :: "+existingUserName);
			
			HttpSession httpSession=req.getSession(true);
			String sessionRole=(String)httpSession.getAttribute("ROLE");		
			
			if(existingUserName){
				if(sessionRole.equalsIgnoreCase("ADMIN")){
					System.out.println("UserName already exist Try another");
					userName="UserName already exist Try another !";
					req.setAttribute("userName", userName);
					req.setAttribute("users", userDao.getAllUser());
					try {req.getRequestDispatcher("WEB-INF/pages/user-list.jsp").forward(req, resp);} 
					catch (ServletException | IOException e) {e.printStackTrace();}
				}
				else{
					System.out.println("UserName already exist Try another");
					userName="UserName already exist Try another !";
					req.setAttribute("userName", userName);
					req.setAttribute("singleUser", userDao.getUser(id));
					try {req.getRequestDispatcher("WEB-INF/pages/user-profile.jsp").forward(req, resp);} 
					catch (ServletException | IOException e) {e.printStackTrace();}
				}

			}
			else{
				
				User user=new User();
				user.setId(id);
				user.setUserName(userName);
				user.setEmail(userEmail);
				user.setCountry(userCountry);
				
				userDao.updateUser(user);
				
				if(sessionRole.equalsIgnoreCase("USER")){
					req.setAttribute("singleUser", userDao.getUser(id));
					try {req.getRequestDispatcher("WEB-INF/pages/user-profile.jsp").forward(req, resp);} 
					catch (ServletException | IOException e) {e.printStackTrace();}
				}
				else{
					try {
						//resp.sendRedirect("list");
						req.setAttribute("users", userDao.getAllUser());
						req.getRequestDispatcher("WEB-INF/pages/user-list.jsp").forward(req, resp); 
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}			
	}

}
