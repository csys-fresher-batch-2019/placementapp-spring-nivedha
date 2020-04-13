package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.Comments;
import com.chainsys.trainingplacementapp.domain.CommentsDTO;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface CommentsDAO {

	void save(Comments comments) throws DbException;

	String findUserNameByUserCourseId(int userCourseId) throws DbException;

	String findCourseNameByUserCourseId(int userCourseId) throws DbException;
	
	public List<CommentsDTO> findComments() throws DbException;


}

