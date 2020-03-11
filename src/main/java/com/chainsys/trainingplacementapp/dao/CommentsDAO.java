package com.chainsys.trainingplacementapp.dao;

import com.chainsys.trainingplacementapp.domain.Comments;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface CommentsDAO {

	void save(Comments c) throws DbException;

	String findUserNameByUserCourseId(int userCourseId) throws DbException;

	String findCourseNameByUserCourseId(int userCourseId) throws DbException;

	String findTrainerNameById(int trainerId) throws DbException;
}
