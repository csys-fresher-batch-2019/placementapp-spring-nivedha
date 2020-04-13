package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.UserCourse;
import com.chainsys.trainingplacementapp.domain.UserCourseDTO;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface UserCourseDAO {
	
	void save(UserCourse userCourse) throws DbException;

	int findCourseDurationByCourseId(int courseId) throws DbException;

	List<UserCourseDTO> findAllByUserId(int userId) throws DbException;
	
	List<UserCourse> findAll() throws DbException;
}
