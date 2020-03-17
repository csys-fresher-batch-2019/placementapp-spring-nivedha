package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.service.LoginService;

@WebServlet("/LoginServ")

public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private LoginService loginService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("name");
		String userPassword = request.getParameter("password");
		HttpSession sess = request.getSession();
		try {
			String a = loginService.loginDetails(userName, userPassword);
			if (a != null) {
				sess.setAttribute("userid", a);
				
				String gotoPage = request.getParameter("gotoPage");
				System.out.println("GotoPAge=" + gotoPage);
				if ( gotoPage!=null && !"".equals(gotoPage.trim()) ) {
					response.sendRedirect(gotoPage);
				}
				else{
					response.sendRedirect("Index.jsp");
				}
			} else
				response.sendRedirect("Login.jsp?errorMessage=Invalid Login");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		}
	}
}