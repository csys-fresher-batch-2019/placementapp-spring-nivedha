package com.chainsys.trainingplacementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.QuestionDAO;
import com.chainsys.trainingplacementapp.domain.Question;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;
import com.chainsys.trainingplacementapp.exception.ValidatorException;
import com.chainsys.trainingplacementapp.validator.Validator;

@Service
public class QuestionService {
	@Autowired
	QuestionDAO questionDAO;

	@Autowired
	Validator validator;

	public List<Question> findAllQuestion() throws ServiceException {
		List<Question> list = null;
		try {
			list = questionDAO.findAll();
		} catch (DbException e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<Question> findQuestionByCategoryId(int categoryId) throws ServiceException {
		List<Question> list = null;
		try {
			list = questionDAO.findByCategoryId(categoryId);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return list;

	}

	public void addQuestions(Question question) throws ServiceException {
		try {
			validator.validateQuestion(question);
			questionDAO.save(question);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
