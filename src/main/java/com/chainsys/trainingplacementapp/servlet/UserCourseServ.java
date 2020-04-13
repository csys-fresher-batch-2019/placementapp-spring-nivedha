package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.domain.UserCourseDTO;
import com.chainsys.trainingplacementapp.service.UserCourseService;

@WebServlet("/UserCourseServ")

public class UserCourseServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	UserCourseService userCourseService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId;
		HttpSession sess = request.getSession(false);
		userId = Integer.parseInt((String) sess.getAttribute("userid"));
		// UserCourseDAO impl1 = DAOFactory.getUserCourseDAO();
		List<UserCourseDTO> list = null;
		try {
			System.out.println(userId);
			list = userCourseService.findUserCourseById(userId);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("user_course", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserCourse.jsp");
		dispatcher.forward(request, response);
	}
}
