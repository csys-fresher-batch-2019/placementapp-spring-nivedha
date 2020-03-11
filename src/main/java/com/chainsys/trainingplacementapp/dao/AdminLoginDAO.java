package com.chainsys.trainingplacementapp.dao;

import com.chainsys.trainingplacementapp.domain.AdminLogin;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface AdminLoginDAO {

	public String findByAdminEmailAndPassword(AdminLogin a) throws DbException;
}
