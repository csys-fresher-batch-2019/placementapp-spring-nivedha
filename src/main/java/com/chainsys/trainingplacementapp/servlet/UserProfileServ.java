package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.domain.Registration;
import com.chainsys.trainingplacementapp.service.RegistrationService;
import com.chainsys.trainingplacementapp.util.Logger;

@WebServlet("/UserProfileServ")
public class UserProfileServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	RegistrationService registrationService;
	private static final Logger log = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess = request.getSession(false);
		int userId = Integer.parseInt((String) sess.getAttribute("userid"));

	List<Registration> list=null;
	try {
		list = registrationService.FindRegistrationById(userId);
		log.info(list);
		request.setAttribute("PROFILE", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserProfile.jsp");
		dispatcher.forward(request, response);
	} catch (Exception e) {
		log.debug(e.getMessage());
	}
	}

}
