package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.domain.Course;
import com.chainsys.trainingplacementapp.service.CourseService;
import com.chainsys.trainingplacementapp.util.Logger;

@WebServlet("/CourseDetailsServ")

public class CourseDetailsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	CourseService courseService;

	private static final Logger log = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Course> list = null;
		String courseName = request.getParameter("courseName");
		// CourseDAO obj = DAOFactory.getCourseDAO();
		try {
			list = courseService.findCourseByName(courseName);
			// list = obj.findByCourseName(courseName);
			log.info(list);
			request.setAttribute("COURSE_LIST", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CourseDetails.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("CourseDetailsServ");
			log.debug(e.getMessage());
		}

	}
}
