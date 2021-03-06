package com.chainsys.trainingplacementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.CourseDAO;
import com.chainsys.trainingplacementapp.domain.Course;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;
import com.chainsys.trainingplacementapp.exception.ValidatorException;
import com.chainsys.trainingplacementapp.validator.Validator;

@Service
public class CourseService {

	@Autowired
	CourseDAO courseDAO;
	
	@Autowired
	Validator validator;

	public List<Course> findCourseByName(String courseName) throws ServiceException {
		List<Course> list = null;
		try {
			list = courseDAO.findByCourseName(courseName);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}
	
	public void addCourseDetails(Course course) throws ServiceException {
		try {
			validator.validateCourse(course);
			courseDAO.save(course);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
