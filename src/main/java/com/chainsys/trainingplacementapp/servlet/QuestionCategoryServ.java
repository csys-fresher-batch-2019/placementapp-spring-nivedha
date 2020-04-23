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

import com.chainsys.trainingplacementapp.domain.QuestionCategory;
import com.chainsys.trainingplacementapp.exception.ServiceException;
import com.chainsys.trainingplacementapp.service.QuestionCategoryService;
import com.chainsys.trainingplacementapp.util.Logger;

@WebServlet("/QuestionCategoryServ")
public class QuestionCategoryServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	QuestionCategoryService questionCategoryService;

	private static final Logger log = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<QuestionCategory> list = null;
		try {
			list = questionCategoryService.findAllCategory();
			log.info(list);
			request.setAttribute("QUESTION_CATEGORY", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("QuestionCategory.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
