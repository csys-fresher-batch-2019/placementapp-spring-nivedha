package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.domain.AdminLogin;
import com.chainsys.trainingplacementapp.service.AdminLoginService;

@WebServlet("/AdminLoginServ")
public class AdminLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	AdminLoginService adminLoginService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = null;
		AdminLogin adminLogin = new AdminLogin();
		adminLogin.setMailId(request.getParameter("email"));
		adminLogin.setPassword(request.getParameter("pass"));
		try {
			msg = adminLoginService.AdminLoginDetails(adminLogin);
			// msg = impl.findByAdminEmailAndPassword(adminLogin);
			System.out.println(msg);
			if (msg.equals("success")) {
				response.sendRedirect("Admin.jsp");
			} else {
				response.sendRedirect("AdminLogin.html");
			}
		} catch (Exception e) {
			response.sendRedirect("Admin.jsp");
			e.printStackTrace();
		}

	}
}
