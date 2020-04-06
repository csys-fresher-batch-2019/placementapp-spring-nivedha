package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

@WebServlet("/AddClientCompanyServ")
public class AddClientCompanyServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ClientCompanyService clientCompanyService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		ClientCompany cc = new ClientCompany();
		ArrayList<ClientCompany> list = new ArrayList<ClientCompany>();
		String name = cc.setCompanyName(request.getParameter("name"));
		cc.setCompanyType(request.getParameter("type"));
		cc.setCompanyAddress(request.getParameter("address"));
		long ph = cc.setPhoneNo(Long.parseLong(request.getParameter("mobileno")));
		cc.setContactPerson(request.getParameter("person"));
		String id = cc.setEmailId(request.getParameter("email"));
		list.add(cc);
		boolean status = false;
		try {
			List<ClientCompany> list1 = clientCompanyService.findCompanyDetails();
			for (ClientCompany c : list1) {
				String cname = c.getCompanyName();
				long m = c.getPhoneNo();
				String mail = c.getEmailId();
				if (cname.equals(name) || m == ph || mail.equals(id)) {
					status = true;
				}
			}
			if (status) {
				request.setAttribute("errorMessage", "Client Detail is Already Exist!!...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AddClientCompany.jsp");
				dispatcher.forward(request, response);
			} else {
				for (ClientCompany clientCompany : list) {
					clientCompanyService.addCompanyDetails(clientCompany);
					out.println(cc.getCompanyName() + " " + "inserted successfully");
					response.sendRedirect("CompanyDetailsServ");
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddClientCompany.jsp");
			dispatcher.forward(request, response);
		}
	}

}
