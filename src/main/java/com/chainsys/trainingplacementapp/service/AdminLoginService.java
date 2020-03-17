package com.chainsys.trainingplacementapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.AdminLoginDAO;
import com.chainsys.trainingplacementapp.domain.AdminLogin;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;
import com.chainsys.trainingplacementapp.exception.ValidatorException;
import com.chainsys.trainingplacementapp.validator.Validator;

@Service
public class AdminLoginService {
	@Autowired
	AdminLoginDAO adminLoginDAO;

	public String AdminLoginDetails(AdminLogin adminLogin) throws ServiceException {
		String admin = null;
		try {
			try {
				Validator.validateAdminLogin(adminLogin);
				admin = adminLoginDAO.findByAdminEmailAndPassword(adminLogin);
			} catch (ValidatorException e) {
				throw new ServiceException(e.getMessage(), e);
			}
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return admin;
	}
}
