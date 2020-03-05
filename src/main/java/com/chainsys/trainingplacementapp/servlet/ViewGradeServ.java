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

import com.chainsys.trainingplacementapp.dao.impl.GradeDAOImpl;
import com.chainsys.trainingplacementapp.domain.Grade;

@WebServlet("/ViewGradeServ")

public class ViewGradeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GradeDAOImpl impl = new GradeDAOImpl();
		List<Grade> list1 = new ArrayList<Grade>();
		try {
			list1 = impl.viewGrade();
			request.setAttribute("view_grade", list1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewGrade.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
