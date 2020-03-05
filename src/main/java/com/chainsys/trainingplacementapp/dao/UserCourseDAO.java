package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.UserCourse;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface UserCourseDAO {
	void addCourseDurationDate(UserCourse list) throws DbException;

	int getDuration(int Duration) throws DbException;

	List<UserCourse> getUserCourseDetails(int userId) throws DbException;
}
