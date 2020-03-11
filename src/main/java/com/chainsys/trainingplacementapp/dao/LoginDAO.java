package com.chainsys.trainingplacementapp.dao;

import com.chainsys.trainingplacementapp.exception.DbException;

public interface LoginDAO {

	public String findByEmailAndPassword(String emailId, String userPassword) throws DbException;
}
