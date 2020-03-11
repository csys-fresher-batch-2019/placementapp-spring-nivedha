package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.trainingplacementapp.dao.AdminLoginDAO;
import com.chainsys.trainingplacementapp.domain.AdminLogin;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;

public class AdminLoginDAOImpl implements AdminLoginDAO {

	private static final Logger logger = LoggerFactory.getLogger(AdminLoginDAOImpl.class);

	public String findByAdminEmailAndPassword(AdminLogin adminLogin) throws DbException {
		String msg = "";
		String sql = "select * from admin where admin_email=? and admin_password=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, adminLogin.getMailId());
			stmt.setString(2, adminLogin.getPassword());
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					msg = "success";
					logger.info(msg);
				} else {
					msg = "failure";
					logger.info(msg);
				}
			}
		} catch (Exception e) {
			throw new DbException("Admin cannot able to Login", e);
		}
		return msg;
	}
}
