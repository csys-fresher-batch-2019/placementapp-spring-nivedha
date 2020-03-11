package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.trainingplacementapp.dao.GradeDAO;
import com.chainsys.trainingplacementapp.dao.InterviewPerformanceDAO;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.factory.DAOFactory;

@WebServlet("/UpdateInterviewStatusServ")

public class UpdateInterviewStatusServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InterviewPerformanceDAO impl = DAOFactory.getInterviewPerformanceDAO();
		int interviewId = Integer.parseInt(request.getParameter("interviewid"));
		int marks = Integer.parseInt(request.getParameter("marks"));
		try {
			impl.updateInterviewMarksById(marks, interviewId);
		} catch (DbException e) {
			e.printStackTrace();
		}
		GradeDAO grade = DAOFactory.getGradeDAO();
		try {
			grade.updateStatusByMarks();
		} catch (DbException e) {
			e.printStackTrace();
		}
		response.sendRedirect("AllInterviewStatusServ");
	}
}
