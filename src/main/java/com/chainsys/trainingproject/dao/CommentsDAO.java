package com.chainsys.trainingproject.dao;

import com.chainsys.trainingproject.model.Comments;
import com.chainsys.util.DbException;

public interface CommentsDAO {

	void addComments(Comments c) throws DbException;

	String getUserName(int userCourseId) throws DbException;

	String getCourseName(int userCourseId) throws DbException;

	String getTrainerName(int trainerId) throws DbException;
}
