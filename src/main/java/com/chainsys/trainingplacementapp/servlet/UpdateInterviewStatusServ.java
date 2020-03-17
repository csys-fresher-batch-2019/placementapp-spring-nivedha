package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.service.GradeService;
import com.chainsys.trainingplacementapp.service.InterviewPerformanceService;

@WebServlet("/UpdateInterviewStatusServ")

public class UpdateInterviewStatusServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	InterviewPerformanceService interviewPerformanceService;

	@Autowired
	GradeService gradeService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// InterviewPerformanceDAO impl = DAOFactory.getInterviewPerformanceDAO();
		int interviewId = Integer.parseInt(request.getParameter("interviewid"));
		int marks = Integer.parseInt(request.getParameter("marks"));
		try {
			interviewPerformanceService.updateInterviewDetails(marks, interviewId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// GradeDAO grade = DAOFactory.getGradeDAO();
		try {
			gradeService.updateInterviewStatusByMarks();
			// grade.updateStatusByMarks();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("AllInterviewStatusServ");
	}
}
