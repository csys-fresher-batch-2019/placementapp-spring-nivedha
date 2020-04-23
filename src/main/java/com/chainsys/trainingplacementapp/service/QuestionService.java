package com.chainsys.trainingplacementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.QuestionDAO;
import com.chainsys.trainingplacementapp.domain.Question;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;

@Service
public class QuestionService {
	@Autowired
	QuestionDAO questionDAO;
	
	public List<Question> findAllQuestion() throws ServiceException
	{
		List<Question> list=null;
		try {
			list=questionDAO.findAll();
		} catch (DbException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public List<Question> findQuestionByCategoryId(int categoryId) throws ServiceException
	{
		List<Question> list=null;
		try {
			list=questionDAO.findByCategoryId(categoryId);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
}
