package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.trainingplacementapp.dao.LoginDAO;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;

@Repository
public class LoginDAOImpl implements LoginDAO {
	private static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);

	public String findByEmailAndPassword(String emailId, String userPassword) throws DbException {
		String sql = "select user_id from registration where mail_id=? and user_password = ?";
		logger.info("Users : " + sql);
		String msg = null;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, emailId);
			pst.setString(2, userPassword);
			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {
					msg = rs.getString("user_id");
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Login", e);

		}

		return msg;
	}

}