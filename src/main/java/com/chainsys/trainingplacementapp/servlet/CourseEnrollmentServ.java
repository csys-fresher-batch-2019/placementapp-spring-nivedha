package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.domain.UserCourse;
import com.chainsys.trainingplacementapp.service.UserCourseService;

@WebServlet("/CourseEnrollmentServ")

public class CourseEnrollmentServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	UserCourseService userCourseService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession ses = request.getSession(false);
		// UserCourseDAO impl = DAOFactory.getUserCourseDAO();
		UserCourse course = (UserCourse) ses.getAttribute("userCourse");
		try {
			// impl.save(course);
			userCourseService.courseEnrollment(course);
			response.sendRedirect("UserCourseServ");
			System.out.println("Enrolled Successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
