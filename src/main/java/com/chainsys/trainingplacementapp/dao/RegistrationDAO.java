package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.Registration;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface RegistrationDAO {

	int save(Registration list) throws DbException;

	void update(String userName,String mailId,String password,String profile,String userCity,long mobileNo,String qualification,String gender,int userId) throws DbException;

	List<Registration> findAll() throws DbException;
	
	List<Registration> findByUserId(int userId) throws DbException;

	void delete(int userId) throws DbException;

	int count() throws DbException;

	List<Registration> findQualificationAndCount() throws DbException;
}
