package com.quinnox.fileUpload.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quinnox.fileUpload.dao.FileUploadDao;
import com.quinnox.fileUpload.model.Image;

@WebServlet(urlPatterns={"/FileDisplayServlet"})
public class FileDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FileDisplayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Image image=new FileUploadDao().getFile();
		request.setAttribute("image", image);
		request.getRequestDispatcher("WEB-INF/views/displayImage.jsp").forward(request, response);
	}

}
