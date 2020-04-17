package com.chainsys.trainingplacementapp.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.domain.Course;
import com.chainsys.trainingplacementapp.service.CourseService;

@WebServlet("/AddCourseServ")

@MultipartConfig
public class AddCourseServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CourseService courseService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Course c = new Course();
		PrintWriter out = response.getWriter();
		ArrayList<Course> list = new ArrayList<Course>();
		c.setCourseName(request.getParameter("name"));
		c.setCourseDuration(Integer.parseInt(request.getParameter("duration")));
		c.setCourseFees(Integer.parseInt(request.getParameter("fees")));
		c.setCoursePdf(request.getParameter("pdfname"));
		c.setCourseImage(request.getParameter("imagename"));
		list.add(c);
		
		final Part filePart = request.getPart("pdf");
		System.out.println();
        final String fileName = getFileName(filePart);
 
        String fileLocation = getServletContext().getInitParameter("upload.location");
        if (fileLocation == null || "null".equals(fileLocation)) {
            fileLocation = "/D:\\chainsys springboot\\springbootapp\\src\\main\\webapp\\assets\\pdf";
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
        
        
        final Part filePart1 = request.getPart("image");
		System.out.println();
        final String fileName1 = getFileName1(filePart1);
 
        String fileLocation1 = getServletContext().getInitParameter("upload.location");
        if (fileLocation1 == null || "null".equals(fileLocation1)) {
            fileLocation1 = "/D:\\chainsys springboot\\springbootapp\\src\\main\\webapp\\assets\\images";
        }
 
        File uploads1 = new File(fileLocation1 + File.separator + fileName1);
        out.println("Upload Location: " + uploads1.getAbsolutePath());
 
        try (InputStream ins = filePart1.getInputStream()) {
 
            Files.copy(ins, uploads1.toPath(), StandardCopyOption.REPLACE_EXISTING);
            out.println("Successfully saved the uploaded file.");
        }
        catch(Exception e) {
            out.println("Unable to save the uploaded file:" + e.getMessage());
        }

		
		
		try {
			for (Course course : list) {
				courseService.addCourseDetails(course);
				response.sendRedirect("HomeCourse.jsp");
				out.println(c.getCourseName() + " " + "inserted successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddCourse.jsp");
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
	
	private String getFileName1(final Part part1) {
        final String partHeader1 = part1.getHeader("content-disposition");
        for (String content1 : partHeader1.split(";")) {
            if (content1.trim().startsWith("filename")) {
                return content1.substring(content1.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
