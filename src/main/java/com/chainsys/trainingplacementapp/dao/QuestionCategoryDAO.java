package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.QuestionCategory;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface QuestionCategoryDAO {

	List<QuestionCategory> findAll() throws DbException;
}
