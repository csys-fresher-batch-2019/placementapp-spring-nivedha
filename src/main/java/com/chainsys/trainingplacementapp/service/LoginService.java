package com.chainsys.trainingplacementapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.LoginDAO;
import com.chainsys.trainingplacementapp.domain.Registration;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;
import com.chainsys.trainingplacementapp.exception.ValidatorException;
import com.chainsys.trainingplacementapp.validator.Validator;

@Service
public class LoginService {
	@Autowired
	Validator validator;
	@Autowired
	LoginDAO loginDAO;
	Registration r=new Registration();
	public String loginDetails(String userName, String userPassword) throws ServiceException {
		String a = null;
		try {
			Validator.validateLogin(userName,userPassword);
			a=loginDAO.findByEmailAndPassword(userName,userPassword);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return a;
	}
}
