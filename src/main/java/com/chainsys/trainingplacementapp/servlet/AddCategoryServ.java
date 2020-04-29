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
import com.chainsys.trainingplacementapp.service.QuestionCategoryService;

@WebServlet("/AddCategoryServ")
public class AddCategoryServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private QuestionCategoryService questionCategoryService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QuestionCategory qc = new QuestionCategory();
		String categoryName = qc.setCategoryName(request.getParameter("categoryname"));
		boolean status = false;
		try {
			List<QuestionCategory> list = questionCategoryService.findAllCategory();
			for (QuestionCategory c : list) {
				String cname = c.getCategoryName();
				if (cname.equals(categoryName)) {
					status = true;
				}
			}
			if (status) {
				request.setAttribute("errorMessage", "This Category is Already Exist!!...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AddCategory.jsp");
				dispatcher.forward(request, response);
			} else {
				questionCategoryService.addCategories(qc);
				response.sendRedirect("DisplayCategoryServ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddCategory.jsp");
			dispatcher.forward(request, response);
		}
	}

}
