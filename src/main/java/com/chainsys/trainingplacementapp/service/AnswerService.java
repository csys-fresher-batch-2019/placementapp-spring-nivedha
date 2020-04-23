package com.chainsys.trainingplacementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.AnswerDAO;
import com.chainsys.trainingplacementapp.domain.Answer;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;

@Service
public class AnswerService {
	@Autowired
	AnswerDAO answerDAO;
	
	public List<Answer> findAllAnswer()throws ServiceException
	{
		List<Answer> list=null;
		try {
			list=answerDAO.findAll();
		} catch (DbException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List<Answer> findAnswerByQuestionId(int questionId)throws ServiceException
	{
		List<Answer> list=null;
		try {
			list=answerDAO.findByQuestionId(questionId);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List<Answer> findQuestionAnswerById(int questionId)throws ServiceException
	{
		List<Answer> list=null;
		try {
			list=answerDAO.findAnswerByQuestionId(questionId);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
