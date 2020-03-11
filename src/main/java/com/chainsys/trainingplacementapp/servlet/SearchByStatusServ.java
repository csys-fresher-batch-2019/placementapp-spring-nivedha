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

import com.chainsys.trainingplacementapp.dao.JoinDAO;
import com.chainsys.trainingplacementapp.domain.UserCompanyDTO;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.factory.DAOFactory;

@WebServlet("/SearchByStatusServ")

public class SearchByStatusServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JoinDAO impl = DAOFactory.getJoinDAO();
		List<UserCompanyDTO> list = new ArrayList<UserCompanyDTO>();
		UserCompanyDTO c = new UserCompanyDTO();
		c.setInterStatus(request.getParameter("status"));
		list.add(c);
		try {
			list = impl.findUsersByInterviewStatus(c);
		} catch (DbException e) {
			e.printStackTrace();
		}
		request.setAttribute("view_status", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewSearchStatus.jsp");
		dispatcher.forward(request, response);
	}
}