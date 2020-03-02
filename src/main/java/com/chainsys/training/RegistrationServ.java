package com.chainsys.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.trainingproject.dao.impl.RegistrationDAOImpl;
import com.chainsys.trainingproject.logger.Logger;
import com.chainsys.trainingproject.model.Registration;

@WebServlet("/RegistrationServ")
public class RegistrationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Registration reg1 = new Registration();
		ArrayList<Registration> list = new ArrayList<Registration>();
		PrintWriter out = response.getWriter();
		reg1.setUserName(request.getParameter("name"));
		reg1.setUserPassword(request.getParameter("password"));
		reg1.setUserCity(request.getParameter("city"));
		reg1.setMobileNo(Long.parseLong(request.getParameter("mobileno")));
		reg1.setMailId(request.getParameter("email"));
		reg1.setQualification(request.getParameter("qualification"));
		reg1.setGender(request.getParameter("gender"));
		list.add(reg1);
		RegistrationDAOImpl impl = new RegistrationDAOImpl();
		try {
			for (Registration register : list) {
				impl.addUserDetails(register);
				log.getInput(register);
			}
			out.println(reg1.getUserName() + " " + "inserted successfully");
		} catch (Exception e) {
			log.error(e);
		}
		response.sendRedirect("Login.jsp");
	}
}
