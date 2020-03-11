package com.chainsys.trainingplacementapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.RegistrationDAO;
import com.chainsys.trainingplacementapp.domain.Registration;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;
import com.chainsys.trainingplacementapp.exception.ValidatorException;
import com.chainsys.trainingplacementapp.validator.Validator;

@Service
public class RegistrationService {

	@Autowired
	Validator validator;
	@Autowired
	RegistrationDAO registrationDAO;

	public void addUserDetails(Registration registration) throws ServiceException {
		try {
			Validator.validateRegistration(registration);
			registrationDAO.save(registration);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
