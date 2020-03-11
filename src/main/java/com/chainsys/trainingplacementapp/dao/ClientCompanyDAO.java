package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.ClientCompany;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface ClientCompanyDAO {

	void save(ClientCompany client) throws DbException;

	List<ClientCompany> findAll() throws DbException;

	List<ClientCompany> findByCompanyName(String companyName) throws DbException;

	void delete(int clientId) throws DbException;

	List<ClientCompany> findCompanyNames() throws DbException;

	int count() throws DbException;

	void update(String companyName, String contactPerson) throws DbException;

}
