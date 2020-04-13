package com.chainsys.trainingplacementapp.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.trainingplacementapp.dao.impl.DiscountCalculation;
import com.chainsys.trainingplacementapp.domain.Course;
import com.chainsys.trainingplacementapp.domain.UserCourse;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.service.UserCourseService;

@WebServlet("/CourseJoinServ")

public class CourseJoinServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	UserCourseService userCourseService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId;
		int courseId;
		String fromPage = "CourseJoinServ";
		HttpSession sess = request.getSession(false);
		HttpSession sess1 = request.getSession();
		UserCourse uc1 = new UserCourse();
		String userIdStr = (String) sess.getAttribute("userid");
		if (userIdStr == null) {
			response.sendRedirect("Login.jsp?gotoPage=" + fromPage);
		} else {
			userId = Integer.parseInt((String) sess.getAttribute("userid"));
			courseId = (Integer) sess.getAttribute("courseid");
			LocalDate currentDate = LocalDate.now();
			ArrayList<UserCourse> list2 = new ArrayList<UserCourse>();
			uc1.setUserId(userId);
			uc1.setCourseId(courseId);
			uc1.setStartDate(currentDate);
			list2.add(uc1);
			for (UserCourse userCourse : list2) {
				int duration = 0;
				try {
					duration = userCourseService.findDurationByCourseId(courseId);
				} catch (Exception e) {
					e.printStackTrace();
				}
				LocalDate completionDate = currentDate.plusMonths(duration);
				userCourse.setCompletionDate(completionDate);
				try {
					Double tot = discount(userId, courseId);
					userCourse.setTotalAmount(tot);
					sess1.setAttribute("userCourse", userCourse);
					response.sendRedirect("CourseJoin.jsp");
				} catch (DbException e) {
					response.sendRedirect("CourseJoinServ");
					e.printStackTrace();
					
				}
			}
		}
	}

	double discount(int userId, int courseId) throws DbException {
		DiscountCalculation dis = new DiscountCalculation();
		UserCourse uc = new UserCourse();
		Course c = new Course();
		uc.setUserId(userId);
		c.setCourseId(courseId);
		int courseCount = dis.count(userId);
		int courseFees = dis.findFeesByCourseId(courseId);
		double discountAmount;
		switch (courseCount) {
		case 2:
			discountAmount = courseFees * .05;
			break;
		case 3:
			discountAmount = courseFees * .10;
			break;
		case 4:
			discountAmount = courseFees * .15;
			break;
		case 5:
			discountAmount = courseFees * .20;
			break;
		default:
			discountAmount = 0;
		}
		double totalAmount = courseFees - discountAmount;
		return totalAmount;
	}
}