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

import com.chainsys.trainingproject.dao.impl.JoinDAOImpl;
import com.chainsys.trainingproject.model.JoinUserCompany;
import com.chainsys.util.DbException;

@WebServlet("/SearchByStatusServ")

public class SearchByStatusServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JoinDAOImpl impl = new JoinDAOImpl();
		List<JoinUserCompany> list = new ArrayList<JoinUserCompany>();
		JoinUserCompany c = new JoinUserCompany();
		c.setInterStatus(request.getParameter("status"));
		list.add(c);
		try {
			list = impl.getUserCompanyDetails(c);
		} catch (DbException e) {
			e.printStackTrace();
		}
		request.setAttribute("view_status", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewSearchStatus.jsp");
		dispatcher.forward(request, response);
		response.sendRedirect("ViewSearchStatus.jsp");
	}
}