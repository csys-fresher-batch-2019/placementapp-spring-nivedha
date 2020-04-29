package com.chainsys.trainingplacementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.QuestionCategoryDAO;
import com.chainsys.trainingplacementapp.domain.QuestionCategory;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;
import com.chainsys.trainingplacementapp.exception.ValidatorException;
import com.chainsys.trainingplacementapp.validator.Validator;

@Service
public class QuestionCategoryService {
	@Autowired
	QuestionCategoryDAO questionCategoryDAO;

	@Autowired
	Validator validator;

	public List<QuestionCategory> findAllCategory() throws ServiceException {
		List<QuestionCategory> list = null;
		try {
			list = questionCategoryDAO.findAll();
		} catch (DbException e) {
			e.printStackTrace();
		}
		return list;

	}

	public void addCategories(QuestionCategory category) throws ServiceException {
		try {
			validator.validateCategory(category);
			questionCategoryDAO.save(category);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
