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

import com.chainsys.trainingplacementapp.domain.Grade;
import com.chainsys.trainingplacementapp.service.GradeService;

@WebServlet("/ViewGradeServ")

public class ViewGradeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	GradeService gradeService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// GradeDAO impl = DAOFactory.getGradeDAO();
		List<Grade> list = null;
		try {
			// list1 = impl.findAll();
			list = gradeService.FindGradeDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("view_grade", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewGrade.jsp");
		dispatcher.forward(request, response);
	}
}
