package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.domain.Answer;
import com.chainsys.trainingplacementapp.service.AnswerService;

@WebServlet("/AddAnswerServ")
public class AddAnswerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AnswerService answerService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Answer a = new Answer();
		ArrayList<Answer> list = new ArrayList<Answer>();

		int questionId = Integer.parseInt(request.getParameter("questionid"));
		a.setQuestionId(questionId);
		a.setAnswer(request.getParameter("answer"));
		list.add(a);
		try {
			for (Answer ans : list) {
				answerService.addAnswers(ans);
				request.setAttribute("errorMessage", "Answer added successfully!!!...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AddAnswer.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddAnswer.jsp");
			dispatcher.forward(request, response);
		}

	}

}
