package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.trainingplacementapp.dao.CourseDAO;
import com.chainsys.trainingplacementapp.domain.Course;
import com.chainsys.trainingplacementapp.factory.DAOFactory;
import com.chainsys.trainingplacementapp.util.Logger;

@WebServlet("/CourseDetailsServ")

public class CourseDetailsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Course> list = new ArrayList<Course>();
		PrintWriter out = response.getWriter();
		String courseName = request.getParameter("courseName");
		CourseDAO obj = DAOFactory.getCourseDAO();
		try {
			list = obj.findByCourseName(courseName);
			log.info(list);
			request.setAttribute("COURSE_LIST", list);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("CourseDetails.jsp");
		dispatcher.forward(request, response);
	}
}
