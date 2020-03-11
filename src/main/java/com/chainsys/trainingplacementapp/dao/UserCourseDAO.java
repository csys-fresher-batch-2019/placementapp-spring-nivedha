package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.UserCourse;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface UserCourseDAO {
	void save(UserCourse list) throws DbException;

	int findCourseDurationByCourseId(int Duration) throws DbException;

	List<UserCourse> findAllByUserId(int userId) throws DbException;
}
