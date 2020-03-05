package com.chainsys.trainingplacementapp.dao;

import com.chainsys.trainingplacementapp.exception.DbException;

public interface AdminLoginDAO {

	public String adminLogin(String email, String password) throws DbException;
}
