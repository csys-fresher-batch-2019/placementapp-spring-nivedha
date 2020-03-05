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

import com.chainsys.trainingplacementapp.dao.impl.ClientCompanyDAOImpl;
import com.chainsys.trainingplacementapp.domain.ClientCompany;
import com.chainsys.trainingplacementapp.exception.DbException;

@WebServlet("/CompanyDetailsServ")

public class CompanyDetailsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClientCompanyDAOImpl impl = new ClientCompanyDAOImpl();
		List<ClientCompany> list1 = new ArrayList<ClientCompany>();
		try {
			list1 = impl.listCompanyDetails();
			request.setAttribute("Company_Details", list1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CompanyDetails.jsp");
			dispatcher.forward(request, response);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}
}
