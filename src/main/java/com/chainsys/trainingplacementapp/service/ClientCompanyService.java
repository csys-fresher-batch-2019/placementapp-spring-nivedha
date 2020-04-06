package com.chainsys.trainingplacementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.ClientCompanyDAO;
import com.chainsys.trainingplacementapp.dao.JoinDAO;
import com.chainsys.trainingplacementapp.domain.ClientCompany;
import com.chainsys.trainingplacementapp.domain.UserCompanyDTO;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;
import com.chainsys.trainingplacementapp.exception.ValidatorException;
import com.chainsys.trainingplacementapp.validator.Validator;

@Service
public class ClientCompanyService {

	@Autowired
	ClientCompanyDAO clientCompanyDAO;

	@Autowired
	JoinDAO joinDAO;

	@Autowired
	Validator validator;

	public List<ClientCompany> findCompanyDetails() throws ServiceException {
		List<ClientCompany> list = null;
		try {
			list = clientCompanyDAO.findAll();
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	public List<UserCompanyDTO> findUserInterviewStatus(UserCompanyDTO userCompanyDTO) throws ServiceException {
		List<UserCompanyDTO> list = null;
		try {
			list = joinDAO.findUsersByInterviewStatus(userCompanyDTO);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	public List<UserCompanyDTO> findStatusByUserId(UserCompanyDTO userCompanyDTO) throws ServiceException {
		List<UserCompanyDTO> list = null;
		try {
			list = joinDAO.findUserStatusByUserId(userCompanyDTO);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	public void addCompanyDetails(ClientCompany clientCompany) throws ServiceException {
		try {
			validator.validateClientCompany(clientCompany);
			clientCompanyDAO.save(clientCompany);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
