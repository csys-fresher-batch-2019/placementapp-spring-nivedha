package com.chainsys.trainingplacementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.TrainerDAO;
import com.chainsys.trainingplacementapp.domain.Trainer;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;

@Service
public class TrainerService {

	@Autowired
	TrainerDAO trainerDAO;

	public List<Trainer> findTrainerDetails() throws ServiceException {
		List<Trainer> list = null;
		try {
			list = trainerDAO.findAll();
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}
}
