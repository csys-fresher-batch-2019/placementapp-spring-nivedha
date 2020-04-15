package com.chainsys.trainingplacementapp.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.exception.ServiceException;
import com.chainsys.trainingplacementapp.service.RegistrationService;
import com.chainsys.trainingplacementapp.util.Logger;

@WebServlet("/UpdateUserProfileServ")
@MultipartConfig
public class UpdateUserProfileServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	private RegistrationService registrationService;
   
	private static final Logger log = Logger.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	PrintWriter out = response.getWriter();	
	int userId=Integer.parseInt(request.getParameter("userId"));
	String userName=request.getParameter("userName");
	String mailId=request.getParameter("email");
	String password=request.getParameter("password");
	String profile=request.getParameter("imageName");
	String city=request.getParameter("city");
	long mobileNo=Long.parseLong(request.getParameter("mobileNo"));
	String qualification=request.getParameter("qualification");
	String gender=request.getParameter("gender");
	
	final Part filePart = request.getPart("image");
	System.out.println();
    final String fileName = getFileName(filePart);

    String fileLocation = getServletContext().getInitParameter("upload.location");
    if (fileLocation == null || "null".equals(fileLocation)) {
        fileLocation = "/D:\\chainsys springboot\\springbootapp\\src\\main\\webapp\\assets\\images\\studentprofile";
    }

    File uploads = new File(fileLocation + File.separator + fileName);
    out.println("Upload Location: " + uploads.getAbsolutePath());

    try (InputStream in = filePart.getInputStream()) {

        Files.copy(in, uploads.toPath(), StandardCopyOption.REPLACE_EXISTING);
        out.println("Successfully saved the uploaded file.");
    }
    catch(Exception e) {
        out.println("Unable to save the uploaded file:" + e.getMessage());
    }
	
	
    try {
		registrationService.updateUserProfile(userName, mailId, password, profile, city, mobileNo, qualification, gender, userId);
		response.sendRedirect("UserProfileServ");
	} catch (ServiceException e) {
		e.printStackTrace();
	}
    
    
	
	}
	
	 private String getFileName(final Part part) {
	        final String partHeader = part.getHeader("content-disposition");
	        for (String content : partHeader.split(";")) {
	            if (content.trim().startsWith("filename")) {
	                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	            }
	        }
	        return null;
	    }

}
