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

@Service
public class ClientCompanyService {

	@Autowired
	ClientCompanyDAO clientCompanyDAO;

	@Autowired
	JoinDAO joinDAO;

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

}
