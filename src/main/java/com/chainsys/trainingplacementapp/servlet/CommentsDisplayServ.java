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

import com.chainsys.trainingplacementapp.domain.CommentsDTO;
import com.chainsys.trainingplacementapp.service.CommentsService;
import com.chainsys.trainingplacementapp.util.Logger;

@WebServlet("/CommentsDisplayServ")
public class CommentsDisplayServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	CommentsService commentsService;

	private static final Logger log = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CommentsDTO> list = null;
		try {
			list = commentsService.findUserComments();
			log.info(list);
			request.setAttribute("COMMENTS", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CommentsDisplay.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}

	}

}
