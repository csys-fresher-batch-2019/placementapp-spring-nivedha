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

import com.chainsys.trainingplacementapp.domain.Question;
import com.chainsys.trainingplacementapp.service.QuestionService;

@WebServlet("/AddQuestionServ")
public class AddQuestionServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private QuestionService questionService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Question q = new Question();
		ArrayList<Question> list = new ArrayList<Question>();

		int categoryId = Integer.parseInt(request.getParameter("categoryid"));
		q.setCategoryId(categoryId);
		String question = q.setQuestion(request.getParameter("question"));
		list.add(q);
		boolean status = false;
		try {
			List<Question> list1 = questionService.findAllQuestion();
			for (Question qus : list1) {
				String ques = qus.getQuestion();
				if (question.equals(ques)) {
					status = true;
				}
			}
			if (status) {
				request.setAttribute("errorMessage", "This Question is Already Exist...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AddQuestion.jsp");
				dispatcher.forward(request, response);
			} else {
				for (Question qn : list) {
					questionService.addQuestions(qn);
					response.sendRedirect("DisplayCategoryServ");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddQuestion.jsp");
			dispatcher.forward(request, response);
		}

	}
}
