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

import com.chainsys.trainingplacementapp.domain.UserCompanyDTO;
import com.chainsys.trainingplacementapp.service.ClientCompanyService;

@WebServlet("/SearchByStatusServ")

public class SearchByStatusServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	ClientCompanyService clientCompanyService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//JoinDAO impl = DAOFactory.getJoinDAO();
		List<UserCompanyDTO> list = new ArrayList<UserCompanyDTO>();
		UserCompanyDTO c = new UserCompanyDTO();
		c.setInterviewStatus(request.getParameter("status"));
		list.add(c);
		try {
			list = clientCompanyService.findUserInterviewStatus(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("view_status", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewSearchStatus.jsp");
		dispatcher.forward(request, response);
	}
}