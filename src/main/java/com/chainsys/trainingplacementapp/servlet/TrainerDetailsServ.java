package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.domain.Trainer;
import com.chainsys.trainingplacementapp.service.TrainerService;

@WebServlet("/TrainerDetailsServ")

public class TrainerDetailsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
@Autowired
TrainerService trainerService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Trainer> list = new ArrayList<Trainer>();
		//TrainerDAO impl1 = DAOFactory.getTrainerDAO();
		try {
			list = trainerService.findTrainerDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("Trainer_Details", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("TrainerDetails.jsp");
		dispatcher.forward(request, response);
	}
}
