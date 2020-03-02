package com.chainsys.training;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.trainingproject.dao.impl.TrainerDAOImpl;
import com.chainsys.trainingproject.model.Trainer;
import com.chainsys.util.DbException;

@WebServlet("/TrainerDetailsServ")

public class TrainerDetailsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TrainerDAOImpl impl = new TrainerDAOImpl();
		Trainer t = new Trainer();
		List<Trainer> list = new ArrayList<Trainer>();
		TrainerDAOImpl impl1 = new TrainerDAOImpl();
		try {
			list = impl1.listTrainerDetails();
		} catch (DbException e) {
			e.printStackTrace();
		}
		request.setAttribute("Trainer_Details", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("TrainerDetails.jsp");
		dispatcher.forward(request, response);
	}
}
