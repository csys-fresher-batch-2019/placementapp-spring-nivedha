package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.Question;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface QuestionDAO {

	List<Question> findAll() throws DbException;
	
	List<Question> findByCategoryId(int categoryId) throws DbException;

	void save(Question question) throws DbException;

}
