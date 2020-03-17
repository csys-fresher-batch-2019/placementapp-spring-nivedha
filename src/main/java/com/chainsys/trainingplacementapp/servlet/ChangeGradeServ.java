package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.domain.Grade;
import com.chainsys.trainingplacementapp.service.GradeService;

@WebServlet("/ChangeGradeServ")

public class ChangeGradeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Autowired
GradeService gradeService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//GradeDAO impl = DAOFactory.getGradeDAO();
		Grade g = new Grade();
		g.setMinMarks(Integer.parseInt(request.getParameter("minmarks")));
		g.setMaxMarks(Integer.parseInt(request.getParameter("maxmarks")));
		g.setStatus(request.getParameter("status"));
		try {
			gradeService.updateInterviewMarkByStatus(g.getMinMarks(), g.getMaxMarks(), g.getStatus());
			//impl.updateMarksByStatus(g.getMinMarks(), g.getMaxMarks(), g.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("ViewGradeServ");
	}
}
