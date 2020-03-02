package com.chainsys.trainingproject.dao;

import java.util.List;

import com.chainsys.trainingproject.model.Registration;
import com.chainsys.util.DbException;

public interface RegistrationDAO {

	void addUserDetails(Registration list) throws DbException;

	void updateUserDetails(int userId, long mobileNo) throws DbException;

	List<Registration> allUserDetails() throws DbException;

	void deleteUserDetails(int userId) throws DbException;

	int getNoOfUsers() throws DbException;

	List<Registration> getDegreeWiseNoOfUsers() throws DbException;
}
