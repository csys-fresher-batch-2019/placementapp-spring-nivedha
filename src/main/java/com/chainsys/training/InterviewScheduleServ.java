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

import com.chainsys.trainingproject.dao.impl.InterviewScheduleDAOImpl;
import com.chainsys.trainingproject.model.InterviewSchedule;
import com.chainsys.util.DbException;

@WebServlet("/InterviewScheduleServ")

public class InterviewScheduleServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InterviewScheduleDAOImpl impl = new InterviewScheduleDAOImpl();
		InterviewSchedule inter = new InterviewSchedule();
		List<InterviewSchedule> list = new ArrayList<InterviewSchedule>();
		try {
			list = impl.allInterviewSchedules();
		} catch (DbException e) {

			e.printStackTrace();
		}
		request.setAttribute("interview_schedule", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("InterviewSchedule.jsp");
		dispatcher.forward(request, response);
	}
}
