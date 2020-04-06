package com.chainsys.trainingplacementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.TrainerDAO;
import com.chainsys.trainingplacementapp.domain.Trainer;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;
import com.chainsys.trainingplacementapp.exception.ValidatorException;
import com.chainsys.trainingplacementapp.validator.Validator;

@Service
public class TrainerService {

	@Autowired
	TrainerDAO trainerDAO;
	@Autowired
	Validator validator;

	public List<Trainer> findTrainerDetails() throws ServiceException {
		List<Trainer> list = null;
		try {
			list = trainerDAO.findAll();
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	public void addTrainerDetails(Trainer trainer) throws ServiceException {
		try {
			validator.validateTrainer(trainer);
			trainerDAO.save(trainer);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
