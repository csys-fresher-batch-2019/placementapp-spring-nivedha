package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.trainingplacementapp.dao.LoginDAO;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ErrorConstant;
import com.chainsys.trainingplacementapp.util.DbConnection;
@Repository
public class LoginDAOImpl implements LoginDAO {
	private static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);

	public String findByEmailAndPassword(String emailId, String userPassword) throws DbException {
		String sql = "select user_id from registration where mail_id=? and user_password = ?";
		logger.info("Users : " + sql);
		String msg = null;
		try (Connection con = DbConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, emailId);
			stmt.setString(2, userPassword);
			try (ResultSet rs = stmt.executeQuery()) {
				
				if (rs.next()) {
					msg = rs.getString("user_id");
				} 
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		
		return msg;
	}
	
}