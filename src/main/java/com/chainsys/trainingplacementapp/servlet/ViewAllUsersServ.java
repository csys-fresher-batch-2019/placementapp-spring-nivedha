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

import com.chainsys.trainingplacementapp.domain.Registration;
import com.chainsys.trainingplacementapp.exception.ServiceException;
import com.chainsys.trainingplacementapp.service.RegistrationService;

@WebServlet("/ViewAllUsersServ")
public class ViewAllUsersServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Autowired
   RegistrationService registrationService; 
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	List<Registration> list=null;
	try {
		list=registrationService.FindRegistration();
	} catch (ServiceException e) {
		e.printStackTrace();
	}
	request.setAttribute("Student_Details", list);
	RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAllUsers.jsp");
	dispatcher.forward(request, response);
	}

}
