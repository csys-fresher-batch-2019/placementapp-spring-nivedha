package com.chainsys.trainingplacementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.QuestionCategoryDAO;
import com.chainsys.trainingplacementapp.domain.QuestionCategory;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;

@Service
public class QuestionCategoryService {
	@Autowired
	QuestionCategoryDAO questionCategoryDAO;

	public List<QuestionCategory> findAllCategory() throws ServiceException {
		List<QuestionCategory> list = null;
		try {
			list = questionCategoryDAO.findAll();
		} catch (DbException e) {
			e.printStackTrace();
		}
		return list;

	}

}
