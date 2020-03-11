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

import com.chainsys.trainingplacementapp.dao.TrainerDAO;
import com.chainsys.trainingplacementapp.domain.Trainer;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.factory.DAOFactory;

@WebServlet("/TrainerDetailsServ")

public class TrainerDetailsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Trainer> list = new ArrayList<Trainer>();
		TrainerDAO impl1 = DAOFactory.getTrainerDAO();
		try {
			list = impl1.findAll();
		} catch (DbException e) {
			e.printStackTrace();
		}
		request.setAttribute("Trainer_Details", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("TrainerDetails.jsp");
		dispatcher.forward(request, response);
	}
}
