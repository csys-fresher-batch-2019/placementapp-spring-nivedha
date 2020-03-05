package com.chainsys.trainingplacementapp.dao;

import com.chainsys.trainingplacementapp.exception.DbException;

public interface LoginDAO {

	public String[] login(String userName, String userPassword) throws DbException;
}
