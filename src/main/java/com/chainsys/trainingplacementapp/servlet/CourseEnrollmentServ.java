package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.trainingplacementapp.dao.UserCourseDAO;
import com.chainsys.trainingplacementapp.domain.UserCourse;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.factory.DAOFactory;

@WebServlet("/CourseEnrollmentServ")

public class CourseEnrollmentServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession ses = request.getSession(false);
		UserCourseDAO impl = DAOFactory.getUserCourseDAO();
		UserCourse course = (UserCourse) ses.getAttribute("userCourse");
		try {
			impl.save(course);
			response.sendRedirect("UserCourseServ");
		} catch (DbException e) {
			e.printStackTrace();
		}
		System.out.println("Enrolled Successfully");
	}
}
