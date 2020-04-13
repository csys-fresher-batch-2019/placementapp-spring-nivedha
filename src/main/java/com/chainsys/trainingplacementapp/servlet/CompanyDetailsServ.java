package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.domain.ClientCompany;
import com.chainsys.trainingplacementapp.service.ClientCompanyService;

@WebServlet("/CompanyDetailsServ")

public class CompanyDetailsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	ClientCompanyService clientCompanyService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ClientCompanyDAO impl = DAOFactory.getClientCompanyDAO();
		List<ClientCompany> list = null;
		try {
			// list1 = impl.findAll();
			list = clientCompanyService.findCompanyDetails();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("Company_Details", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CompanyDetails.jsp");
		dispatcher.forward(request, response);
	}
}
