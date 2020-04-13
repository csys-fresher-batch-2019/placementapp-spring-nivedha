package com.chainsys.trainingplacementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.CommentsDAO;
import com.chainsys.trainingplacementapp.domain.Comments;
import com.chainsys.trainingplacementapp.domain.CommentsDTO;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;
import com.chainsys.trainingplacementapp.exception.ValidatorException;
import com.chainsys.trainingplacementapp.validator.Validator;

@Service
public class CommentsService {
	@Autowired
	CommentsDAO commentsDAO;

	@Autowired
	Validator validator;

	public List<CommentsDTO> findUserComments() throws ServiceException {
		List<CommentsDTO> list = null;
		try {
			list = commentsDAO.findComments();
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	public void addComments(Comments comments) throws ServiceException {
		try {
			validator.validateComments(comments);
			commentsDAO.save(comments);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
