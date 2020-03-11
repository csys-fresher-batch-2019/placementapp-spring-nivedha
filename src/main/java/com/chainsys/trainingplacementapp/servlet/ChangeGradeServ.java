package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.trainingplacementapp.dao.GradeDAO;
import com.chainsys.trainingplacementapp.domain.Grade;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.factory.DAOFactory;

@WebServlet("/ChangeGradeServ")

public class ChangeGradeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GradeDAO impl = DAOFactory.getGradeDAO();
		Grade g = new Grade();
		g.setMinMarks(Integer.parseInt(request.getParameter("minmarks")));
		g.setMaxMarks(Integer.parseInt(request.getParameter("maxmarks")));
		g.setStatus(request.getParameter("status"));
		try {
			impl.updateMarksByStatus(g.getMinMarks(), g.getMaxMarks(), g.getStatus());
		} catch (DbException e) {
			e.printStackTrace();
		}
		response.sendRedirect("ViewGradeServ");
	}
}
