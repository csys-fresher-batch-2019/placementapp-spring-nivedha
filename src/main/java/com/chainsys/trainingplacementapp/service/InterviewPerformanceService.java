package com.chainsys.trainingplacementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.InterviewPerformanceDAO;
import com.chainsys.trainingplacementapp.dao.UserCourseDAO;
import com.chainsys.trainingplacementapp.domain.InterviewPerformance;
import com.chainsys.trainingplacementapp.domain.UserCourse;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;

@Service
public class InterviewPerformanceService {

	@Autowired
	InterviewPerformanceDAO interviewPerformanceDAO;
	
	@Autowired
	UserCourseDAO userCourseDAO;

	public List<InterviewPerformance> findInterviewPerformance() throws ServiceException {
		List<InterviewPerformance> list = null;
		try {
			list = interviewPerformanceDAO.findAll();
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}
	
	public int getNoOfCourses(int userId) {
		int noOfCourses = 0;
		try {
			List<UserCourse> courses = userCourseDAO.findAllByUserId(userId);
			noOfCourses = courses.size();
		} catch (DbException e) {
			e.printStackTrace();
		}
		return noOfCourses;
	}

	public void addInterviewDetails(int clientId, int userId) throws ServiceException {
		try {
			int noOfCourses = getNoOfCourses(userId);
			if ( noOfCourses >=1) {
				interviewPerformanceDAO.save(clientId, userId);
			}
			else {
				throw new ServiceException("You are not eligible to attend this interview.");
			}
		} catch (DbException e) {
			throw new ServiceException(e);
		}
	}

	public void updateInterviewDetails(int marks, int performId) throws ServiceException {
		try {
			interviewPerformanceDAO.updateInterviewMarksById(marks, performId);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
	}
}
