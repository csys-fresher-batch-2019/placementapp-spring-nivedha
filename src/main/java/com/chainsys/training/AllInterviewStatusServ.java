package com.chainsys.training;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.trainingproject.dao.impl.InterviewPerformanceDAOImpl;
import com.chainsys.trainingproject.model.InterviewPerformance;
import com.chainsys.util.DbException;

@WebServlet("/AllInterviewStatusServ")
public class AllInterviewStatusServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  InterviewPerformanceDAOImpl impl=new InterviewPerformanceDAOImpl();
	        List<InterviewPerformance> list=new ArrayList<InterviewPerformance>();
	        try {
				list=impl.viewPerformanceStatus();
			} catch (DbException e) {
				e.printStackTrace();
			}
	    	request.setAttribute("interviewstatus", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UserInterviewStatus.jsp");
			dispatcher.forward(request, response);
	       
	}
}
