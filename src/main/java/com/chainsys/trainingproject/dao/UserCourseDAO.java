package com.chainsys.trainingproject.dao;

import java.util.List;

import com.chainsys.trainingproject.model.UserCourse;
import com.chainsys.util.DbException;

public interface UserCourseDAO {
	void addCourseDurationDate(UserCourse list) throws DbException;

	int getDuration(int Duration) throws DbException;

	List<UserCourse> getUserCourseDetails(int userId) throws DbException;
}
