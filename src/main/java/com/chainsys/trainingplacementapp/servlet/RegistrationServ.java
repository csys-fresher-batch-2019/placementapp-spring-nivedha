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

import com.chainsys.trainingplacementapp.dao.RegistrationDAO;
import com.chainsys.trainingplacementapp.domain.Registration;
import com.chainsys.trainingplacementapp.factory.DAOFactory;
import com.chainsys.trainingplacementapp.service.RegistrationService;
import com.chainsys.trainingplacementapp.util.Logger;

@WebServlet("/RegistrationServ")
public class RegistrationServ extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RegistrationService registrationService;

	private static final Logger log = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Registration reg1 = new Registration();
		ArrayList<Registration> list = new ArrayList<Registration>();
		PrintWriter out = response.getWriter();
		reg1.setUserName(request.getParameter("name"));
		reg1.setUserPassword(request.getParameter("password"));
		reg1.setUserCity(request.getParameter("city"));
		long ph = reg1.setMobileNo(Long.parseLong(request.getParameter("mobileno")));
		String id = reg1.setMailId(request.getParameter("email"));
		reg1.setQualification(request.getParameter("qualification"));
		reg1.setGender(request.getParameter("gender"));
		list.add(reg1);
		boolean status = false;
		RegistrationDAO dao = DAOFactory.getRegistrationDAO();
		try {
			List<Registration> list1 = dao.findAll();
			for (Registration r : list1) {
				long m = r.getMobileNo();
				String mail = r.getMailId();
				if (m == ph || mail.equals(id)) {
					status = true;
				}
			}
			if (status) {
				request.setAttribute("errorMessage", "Registered Already!! login...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
				dispatcher.forward(request, response);
			} else {
				for (Registration register : list) {
					registrationService.addUserDetails(register);
					log.info(register);
					response.sendRedirect("Login.jsp");
				}
				out.println(reg1.getUserName() + " " + "inserted successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
			dispatcher.forward(request, response);
		}

	}
}
