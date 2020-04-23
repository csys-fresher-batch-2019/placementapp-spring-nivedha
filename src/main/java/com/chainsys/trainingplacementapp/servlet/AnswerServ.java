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

import com.chainsys.trainingplacementapp.domain.Answer;
import com.chainsys.trainingplacementapp.exception.ServiceException;
import com.chainsys.trainingplacementapp.service.AnswerService;
import com.chainsys.trainingplacementapp.util.Logger;

@WebServlet("/AnswerServ")
public class AnswerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	AnswerService answerService;

	private static final Logger log = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Answer> list = null;
		int questionId = Integer.parseInt(request.getParameter("Question_id"));
		try {
			list = answerService.findQuestionAnswerById(questionId);
			log.info(list);
			request.setAttribute("ANSWERS", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Answer.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
