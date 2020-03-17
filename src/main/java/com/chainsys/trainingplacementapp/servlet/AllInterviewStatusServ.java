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

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.domain.InterviewPerformance;
import com.chainsys.trainingplacementapp.service.InterviewPerformanceService;

@WebServlet("/AllInterviewStatusServ")
public class AllInterviewStatusServ extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
@Autowired
InterviewPerformanceService interviewPerformanceService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		InterviewPerformanceDAO impl = DAOFactory.getInterviewPerformanceDAO();
		List<InterviewPerformance> list = new ArrayList<InterviewPerformance>();
		try {
//			list = impl.findAll();
			list = interviewPerformanceService.findInterviewPerformance();
			request.setAttribute("interviewstatus", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UserInterviewStatus.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("");
		}
		
	}
}
