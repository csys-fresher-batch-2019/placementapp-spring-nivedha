package com.chainsys.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chainsys.trainingproject.dao.LoginDAO;
import com.chainsys.trainingproject.logger.Logger;
import com.chainsys.util.DbConnection;
import com.chainsys.util.DbException;

public class LoginDAOImpl implements LoginDAO {
	private static final Logger log = Logger.getInstance();

	public String[] login(String email, String userPassword) throws DbException {
		int userId = 0;
		String msg = "";
		String s[] = new String[2];
		String sql = "select mail_id,user_password from registration where mail_id= ? and user_password = ?";
		String sql1 = "select user_id from registration where mail_id=?";
		try (Connection con = DbConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				PreparedStatement stmt1 = con.prepareStatement(sql1);) {
			stmt.setString(1, email);
			stmt.setString(2, userPassword);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					msg = email + "" + userPassword;
				} else
					msg = "Login Failed";
			}
		} catch (Exception e) {
			log.error(e);
		}
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt1 = con.prepareStatement(sql1);) {
			stmt1.setString(1, email);
			try (ResultSet rs1 = stmt1.executeQuery()) {
				if (rs1.next()) {
					userId = rs1.getInt("user_id");
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		s[0] = msg;
		s[1] = userId + "";
		return s;
	}
}