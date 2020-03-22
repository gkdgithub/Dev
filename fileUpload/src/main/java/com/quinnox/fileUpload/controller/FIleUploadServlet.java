package com.quinnox.fileUpload.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.quinnox.fileUpload.dao.FileUploadDao;

@WebServlet(urlPatterns={"/", "/fileUpload"})
@MultipartConfig
public class FIleUploadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "D:\\Binary\\Upload";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
 
    
    public FIleUploadServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/upload.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		boolean status=false;
		
		// checks if the request actually contains upload file
		//process only if its multipart content
		boolean isMultiPart=ServletFileUpload.isMultipartContent(request);
		if(isMultiPart){
			FileItemFactory fileItemFactory=new DiskFileItemFactory();
			
			// sets memory threshold - beyond which files are stored in disk
			//((DiskFileItemFactory) fileItemFactory).setSizeThreshold(MEMORY_THRESHOLD);
			
			ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
			
	        // sets maximum size of upload file
			servletFileUpload.setFileSizeMax(MAX_FILE_SIZE);
	         
	        // sets maximum size of request (include file + form data)
			servletFileUpload.setSizeMax(MAX_REQUEST_SIZE);
			
			try {
				List<FileItem> multiPartItems=servletFileUpload.parseRequest(request);
				// processes only fields that are not form fields
				for (FileItem fileItem : multiPartItems) {
					if(!fileItem.isFormField()){
						String fileName=new File(fileItem.getName()).getName();
						String filePath=UPLOAD_DIRECTORY+File.separator+""+new Date().getTime()+fileName;
						//String filePath=UPLOAD_DIRECTORY+File.separator+fileName;
						System.out.println(filePath);
						fileItem.write(new File(filePath));
						status=new FileUploadDao().saveFileToDB(fileName, filePath);
					}
				}
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			request.setAttribute("message", "Error: Form must has enctype=multipart/form-data.");
			request.getRequestDispatcher("WEB-INF/views/message.jsp").forward(request, response);
		}
		if(status){
			request.setAttribute("message", "Upload has been done successfully!");
			request.getRequestDispatcher("WEB-INF/views/message.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "Something Went wrong ! ");
			request.getRequestDispatcher("WEB-INF/views/message.jsp").forward(request, response);
		}
		
	}
	
}
