package com.chainsys.trainingplacementapp.dao;

import com.chainsys.trainingplacementapp.domain.Comments;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface CommentsDAO {

	void addComments(Comments c) throws DbException;

	String getUserName(int userCourseId) throws DbException;

	String getCourseName(int userCourseId) throws DbException;

	String getTrainerName(int trainerId) throws DbException;
}
