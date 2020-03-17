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

import com.chainsys.trainingplacementapp.domain.InterviewSchedule;
import com.chainsys.trainingplacementapp.service.InterviewPerformanceService;
import com.chainsys.trainingplacementapp.service.InterviewScheduleService;

@WebServlet("/InterviewScheduleServ")

public class InterviewScheduleServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	InterviewScheduleService interviewScheduleService;
	
	@Autowired
	InterviewPerformanceService interviewPerformanceService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// InterviewScheduleDAO impl = DAOFactory.getInterviewScheduleDAO();
		String fromPage = "InterviewScheduleServ";
		HttpSession sess = request.getSession(false);
		String userIdStr = (String) sess.getAttribute("userid");
		if (userIdStr == null) {
			response.sendRedirect("Login.jsp?gotoPage=" + fromPage);
		} else {
		
		    List<InterviewSchedule> list = null;
		try {
			int userId = Integer.parseInt(userIdStr);
			int noOfCourses = interviewPerformanceService.getNoOfCourses(userId);
			request.setAttribute("NO_OF_COURSES_ENROLLED", noOfCourses);
			list = interviewScheduleService.findScheduleByInterviewDate();
			request.setAttribute("interview_schedule", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("InterviewSchedule.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("InterviewSchedule.jsp");
			dispatcher.forward(request, response);
		}
		
	}
	}
	
}
