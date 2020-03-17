package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.service.InterviewPerformanceService;

@WebServlet("/AttendInterviewServ")

public class AttendInterviewServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Autowired
InterviewPerformanceService interviewPerformanceService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//InterviewPerformanceDAO impl = DAOFactory.getInterviewPerformanceDAO();
		HttpSession sess = request.getSession();
		int clientId = Integer.parseInt(request.getParameter("Client_id"));
		String userIdStr = (String) sess.getAttribute("userid");
		int userId = Integer.parseInt(userIdStr);
		System.out.println(userIdStr);
		try {
			interviewPerformanceService.addInterviewDetails(clientId, userId);
			//impl.save(clientId, userId);
			response.sendRedirect("ViewInterviewStatusServ");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("InterviewScheduleServ?errorMessage="+e.getMessage());
		}
	}
}
