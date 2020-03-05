package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chainsys.trainingplacementapp.dao.AdminLoginDAO;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;
import com.chainsys.trainingplacementapp.util.Logger;

public class AdminLoginDAOImpl implements AdminLoginDAO {

	private static final Logger log = Logger.getInstance();

	public String adminLogin(String email, String password) throws DbException {
		String msg = "";
		String sql = "select * from admin where admin_email=? and admin_password=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, email);
			stmt.setString(2, password);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					msg = "success";
					log.getInput("LOGGED IN");
				} else {
					msg = "failure";
					log.getInput("INVALID USERNAME OR PASSWORD");
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return msg;
	}
}
