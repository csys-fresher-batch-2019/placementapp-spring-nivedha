package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.Registration;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface RegistrationDAO {

	int addUserDetails(Registration list) throws DbException;

	void updateUserDetails(int userId, long mobileNo) throws DbException;

	List<Registration> allUserDetails() throws DbException;

	void deleteUserDetails(int userId) throws DbException;

	int getNoOfUsers() throws DbException;

	List<Registration> getDegreeWiseNoOfUsers() throws DbException;
}
