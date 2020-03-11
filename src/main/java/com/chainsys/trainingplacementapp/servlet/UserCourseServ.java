package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/UserCourseServ")

public class UserCourseServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId;
		HttpSession sess = request.getSession(false);
		userId = Integer.parseInt((String) sess.getAttribute("userid"));
		UserCourseDAO impl1 =DAOFactory.getUserCourseDAO();
		UserCourse uc1 = new UserCourse();
		uc1.setUserId(userId);
		List<UserCourse> list1 = new ArrayList<UserCourse>();
		try {
			list1 = impl1.findAllByUserId(uc1.getUserId());
		} catch (DbException e) {
			e.printStackTrace();
		}
		request.setAttribute("user_course", list1);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserCourse.jsp");
		dispatcher.forward(request, response);
	}
}
