package com.chainsys.training;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.trainingproject.dao.impl.LoginDAOImpl;
import com.chainsys.trainingproject.logger.Logger;

@WebServlet("/LoginServ")

public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginDAOImpl impl = new LoginDAOImpl();
		String userName = request.getParameter("name");
		String userPassword = request.getParameter("password");
		HttpSession sess = request.getSession();
		try {
			String a[] = impl.login(userName, userPassword);
			sess.setAttribute("userid", a[1]);
			if (a[0].equals(userName + userPassword)) {
				response.sendRedirect("HomeCourse.jsp");
			} else {
				response.sendRedirect("Login.jsp?errorMessage=Invalid Login");
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
}