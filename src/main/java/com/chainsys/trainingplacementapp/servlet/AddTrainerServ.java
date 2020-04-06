package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/AddTrainerServ")
public class AddTrainerServ extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TrainerService trainerService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Trainer t = new Trainer();
		PrintWriter out = response.getWriter();
		ArrayList<Trainer> list = new ArrayList<Trainer>();
		t.setTrainerName(request.getParameter("name"));
		t.setTrainerQualification(request.getParameter("qualification"));
		t.setTrainerSpecialist(request.getParameter("specialist"));
		t.setTrainerExperience(Integer.parseInt(request.getParameter("experience")));
		String id = t.setEmailId(request.getParameter("email"));
		long ph = t.setContactNumber(Long.parseLong(request.getParameter("mobileno")));
		list.add(t);
		boolean status = false;
		try {
			List<Trainer> list1 = trainerService.findTrainerDetails();
			for (Trainer tr : list1) {
				long m = tr.getContactNumber();
				String mail = tr.getEmailId();
				if (m == ph || mail.equals(id)) {
					status = true;
				}
			}
			if (status) {
				request.setAttribute("errorMessage", "Trainer Detail Already Exist!!...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AddTrainer.jsp");
				dispatcher.forward(request, response);
			} else {
				for (Trainer trainer : list) {
					trainerService.addTrainerDetails(trainer);
					out.println(t.getTrainerName() + " " + "inserted successfully");
				}
				response.sendRedirect("TrainerDetailsServ");

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddTrainer.jsp");
			dispatcher.forward(request, response);
		}
	}

}
