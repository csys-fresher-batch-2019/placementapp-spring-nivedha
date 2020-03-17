package com.chainsys.trainingplacementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.UserCourseDAO;
import com.chainsys.trainingplacementapp.domain.UserCourse;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;

@Service
public class UserCourseService {
	@Autowired
	UserCourseDAO userCourseDAO;

	public void courseEnrollment(UserCourse usercourse) throws ServiceException {
		try {
			userCourseDAO.save(usercourse);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
	}

	public int findDurationByCourseId(int courseId) throws ServiceException {
		int duration = 0;
		try {
			duration = userCourseDAO.findCourseDurationByCourseId(courseId);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return duration;
	}

	public List<UserCourse> findUserCourseById(int userId) throws ServiceException {
		List<UserCourse> list = null;
		try {
			list=userCourseDAO.findAllByUserId(userId);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}
}
