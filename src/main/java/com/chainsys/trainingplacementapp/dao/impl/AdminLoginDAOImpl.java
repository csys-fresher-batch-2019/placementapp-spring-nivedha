package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.trainingplacementapp.dao.AdminLoginDAO;
import com.chainsys.trainingplacementapp.domain.AdminLogin;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;

@Repository
public class AdminLoginDAOImpl implements AdminLoginDAO {

	private static final Logger logger = LoggerFactory.getLogger(AdminLoginDAOImpl.class);

	/**
	 * used to display the emailId and password from the Admin 
	 */
	public String findByAdminEmailAndPassword(AdminLogin adminLogin) throws DbException {
		String msg = "";
		String sql = "select * from admin where admin_email=? and admin_password=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, adminLogin.getMailId());
			pst.setString(2, adminLogin.getPassword());
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					msg = "success";
					logger.info(msg);
				} else {
					msg = "failure";
					logger.info(msg);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Admin cannot able to Login", e);
		}
		return msg;
	}
}
