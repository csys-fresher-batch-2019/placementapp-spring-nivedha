package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.trainingplacementapp.dao.impl.AdminLoginDAOImpl;
import com.chainsys.trainingplacementapp.exception.DbException;

@WebServlet("/AdminLoginServ")
public class AdminLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		AdminLoginDAOImpl impl = new AdminLoginDAOImpl();
		String msg = null;
		String mailId = request.getParameter("email");
		String password = request.getParameter("pass");
		try {
			msg = impl.adminLogin(mailId, password);
		} catch (DbException e) {
			e.printStackTrace();
		}
		System.out.println(msg);
		if (msg.equals("success")) {
			response.sendRedirect("Admin.jsp");
		} else {
			response.sendRedirect("AdminLogin.html");
		}
	}
}
