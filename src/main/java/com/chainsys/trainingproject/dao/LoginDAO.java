package com.chainsys.trainingproject.dao;

import com.chainsys.util.DbException;

public interface LoginDAO {

	public String[] login(String userName, String userPassword) throws DbException;
}
