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

import com.chainsys.trainingplacementapp.domain.Comments;
import com.chainsys.trainingplacementapp.domain.CommentsDTO;
import com.chainsys.trainingplacementapp.domain.UserCourse;
import com.chainsys.trainingplacementapp.service.CommentsService;
import com.chainsys.trainingplacementapp.service.UserCourseService;

@WebServlet("/AddCommentsServlet")
public class AddCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CommentsService commentsService;

	@Autowired
	private UserCourseService userCourseService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Comments c = new Comments();
		ArrayList<Comments> list = new ArrayList<Comments>();
		int ucId = c.setUserCourseId(Integer.parseInt(request.getParameter("usercourseid")));
		c.setInstitutionRating(Integer.parseInt(request.getParameter("rating")));
		c.setCourseComments(request.getParameter("comments"));
		list.add(c);
		System.out.println(list);

		boolean status = false;
		try {
			List<UserCourse> list1 = userCourseService.findAllUserCourse();
			for (UserCourse uc : list1) {
				int userCourseId = uc.getUserCourseId();
				if (userCourseId == ucId) {
					status = true;
					System.out.println(status);
				}
			}
			if (status) {
						for (Comments comments : list) {
							commentsService.addComments(comments);
							response.sendRedirect("CommentsDisplayServ");
						}
				}
				
			else {
				request.setAttribute("errorMessage", "Invalid ID!!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AddComments.jsp");
				dispatcher.forward(request, response);
			}
			out.println(c.getUserCourseId() + " " + "inserted successfully");
		}

		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddComments.jsp");
			dispatcher.forward(request, response);
		}

	}

}
