package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.Answer;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface AnswerDAO {

	List<Answer> findAll() throws DbException;

	List<Answer> findByQuestionId(int questionId) throws DbException;
	
	List<Answer> findAnswerByQuestionId(int questionId) throws DbException;
}
