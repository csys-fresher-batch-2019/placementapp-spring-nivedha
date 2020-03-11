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
import javax.servlet.http.HttpSession;

import com.chainsys.trainingplacementapp.dao.JoinDAO;
import com.chainsys.trainingplacementapp.domain.UserCompanyDTO;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.factory.DAOFactory;

@WebServlet("/ViewInterviewStatusServ")

public class ViewInterviewStatusServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		JoinDAO impl = DAOFactory.getJoinDAO();
		UserCompanyDTO c = new UserCompanyDTO();
		HttpSession sess = request.getSession(false);
		String userIdStr = (String) sess.getAttribute("userid");
		if (userIdStr == null) {
			out.print(userIdStr);
			response.sendRedirect("Login.jsp");
		} else {
			Integer userId = Integer.parseInt(userIdStr);
			List<UserCompanyDTO> list = new ArrayList<UserCompanyDTO>();
			c.setUserId(userId);
			try {
				list = impl.findUserStatusByUserId(c);
				request.setAttribute("Interview_Status", list);
				RequestDispatcher dispatcher = request.getRequestDispatcher("InterviewStatus.jsp");
				dispatcher.forward(request, response);
			} catch (DbException e) {
				e.printStackTrace();
			}
		}
	}
}
