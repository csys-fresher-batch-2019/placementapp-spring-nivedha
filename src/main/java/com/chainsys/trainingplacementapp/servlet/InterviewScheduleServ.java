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

import com.chainsys.trainingplacementapp.dao.InterviewScheduleDAO;
import com.chainsys.trainingplacementapp.domain.InterviewSchedule;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.factory.DAOFactory;

@WebServlet("/InterviewScheduleServ")

public class InterviewScheduleServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InterviewScheduleDAO impl = DAOFactory.getInterviewScheduleDAO();
		List<InterviewSchedule> list = new ArrayList<InterviewSchedule>();
		try {
			list = impl.findAllByInterviewDate();
		} catch (DbException e) {

			e.printStackTrace();
		}
		request.setAttribute("interview_schedule", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("InterviewSchedule.jsp");
		dispatcher.forward(request, response);
	}
}
