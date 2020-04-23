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

import com.chainsys.trainingplacementapp.domain.Question;
import com.chainsys.trainingplacementapp.exception.ServiceException;
import com.chainsys.trainingplacementapp.service.QuestionService;
import com.chainsys.trainingplacementapp.util.Logger;

@WebServlet("/QuestionServ")
public class QuestionServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	QuestionService questionService;

	private static final Logger log = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Question> list = null;
		int categoryId = Integer.parseInt(request.getParameter("Category_id"));
		try {
			list = questionService.findQuestionByCategoryId(categoryId);
			log.info(list);
			request.setAttribute("QUESTIONS", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Question.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
