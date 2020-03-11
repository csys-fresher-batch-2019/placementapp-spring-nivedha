package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.trainingplacementapp.dao.AdminLoginDAO;
import com.chainsys.trainingplacementapp.domain.AdminLogin;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.factory.DAOFactory;

@WebServlet("/AdminLoginServ")
public class AdminLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminLoginDAO impl = DAOFactory.getAdminLoginDAO();
		String msg = null;
		AdminLogin adminLogin = new AdminLogin();
		adminLogin.setMailId(request.getParameter("email"));
		adminLogin.setPassword(request.getParameter("pass"));
		try {
			msg = impl.findByAdminEmailAndPassword(adminLogin);
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
