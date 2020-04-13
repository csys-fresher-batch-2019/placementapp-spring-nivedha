package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.domain.Course;
import com.chainsys.trainingplacementapp.service.CourseService;

@WebServlet("/AddCourseServ")
public class AddCourseServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CourseService courseService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Course c = new Course();
		PrintWriter out = response.getWriter();
		ArrayList<Course> list = new ArrayList<Course>();
		c.setCourseName(request.getParameter("name"));
		c.setCourseDuration(Integer.parseInt(request.getParameter("duration")));
		c.setCourseFees(Integer.parseInt(request.getParameter("fees")));
		c.setCoursePdf(request.getParameter("pdf"));
		c.setCourseImage(request.getParameter("image"));
		list.add(c);
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

}
