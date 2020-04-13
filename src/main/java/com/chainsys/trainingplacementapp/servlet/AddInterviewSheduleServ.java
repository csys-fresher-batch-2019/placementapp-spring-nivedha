package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.domain.ClientCompany;
import com.chainsys.trainingplacementapp.domain.InterviewSchedule;
import com.chainsys.trainingplacementapp.service.InterviewScheduleService;
import com.chainsys.trainingplacementapp.service.ClientCompanyService;


@WebServlet("/AddInterviewSheduleServ")
public class AddInterviewSheduleServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(AddInterviewSheduleServ.class);

	@Autowired
	private InterviewScheduleService interviewScheduleService;

	@Autowired
	private ClientCompanyService clientCompanyService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InterviewSchedule is = new InterviewSchedule();
		PrintWriter out = response.getWriter();
		ArrayList<InterviewSchedule> list = new ArrayList<InterviewSchedule>();
		int clientId=is.setClientId(Integer.parseInt(request.getParameter("clientid")));
		is.setJobTitle(request.getParameter("title"));
		is.setJobRequirement(request.getParameter("requirement"));
		String createdDate = request.getParameter("createdate");
		is.setCreatedDate(LocalDate.parse(createdDate));
		String InterviewDate = request.getParameter("interviewdate");
		is.setInterviewDate(LocalDate.parse(InterviewDate));
		String interviewTime = request.getParameter("time");
		is.setInterviewTime(LocalTime.parse(interviewTime));
		list.add(is);
		LOGGER.debug("schedule list" + list);
		boolean status = false;
		try {
			List<ClientCompany> list1=clientCompanyService.findCompanyDetails();
			for(ClientCompany cc:list1)
			{
				int id=cc.getClientId();
				if(id==clientId)
				{
					status=true;
				}
			}
			if(status)
			{
			for (InterviewSchedule interviewSchedule : list) {
				interviewScheduleService.addInterviewScheduleDetails(interviewSchedule);
			}
			out.println(is.getInterviewId() + " " + "inserted successfully");
			response.sendRedirect("Admin.jsp");
			}else
			{
				request.setAttribute("errorMessage", "Invalid Client Id!!!...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AddInterviewSchedule.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddInterviewSchedule.jsp");
			dispatcher.forward(request, response);
		}
	}
}
