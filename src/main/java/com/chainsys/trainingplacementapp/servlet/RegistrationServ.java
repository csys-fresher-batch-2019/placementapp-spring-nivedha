package com.chainsys.trainingplacementapp.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.domain.Registration;
import com.chainsys.trainingplacementapp.service.RegistrationService;
import com.chainsys.trainingplacementapp.util.Logger;

@WebServlet("/RegistrationServ")
@MultipartConfig
public class RegistrationServ extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RegistrationService registrationService;

	private static final Logger log = Logger.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		Registration reg1 = new Registration();
		ArrayList<Registration> list = new ArrayList<Registration>();
		PrintWriter out = response.getWriter();
		reg1.setUserName(request.getParameter("name"));
		reg1.setUserPassword(request.getParameter("password"));
		reg1.setUserCity(request.getParameter("city"));
		long ph = reg1.setMobileNo(Long.parseLong(request.getParameter("mobileno")));
		String id = reg1.setMailId(request.getParameter("email"));
		reg1.setQualification(request.getParameter("qualification"));
		reg1.setGender(request.getParameter("gender"));
		reg1.setProfile(request.getParameter("imagename"));
		list.add(reg1);
		System.out.println(reg1.getProfile());
		
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

		boolean status = false;
		try {
			List<Registration> list1 = registrationService.FindRegistration();
			for (Registration r : list1) {
				long m = r.getMobileNo();
				String mail = r.getMailId();
				if (m == ph || mail.equals(id)) {
					status = true;
				}
			}
			if (status) {
				request.setAttribute("errorMessage", "Registered Already!! login...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
				dispatcher.forward(request, response);
			} else {
				for (Registration register : list) {
					registrationService.addUserDetails(register);
					log.info(register);
					response.sendRedirect("Login.jsp");
				}
				out.println(reg1.getUserName() + " " + "inserted successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
			dispatcher.forward(request, response);
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
