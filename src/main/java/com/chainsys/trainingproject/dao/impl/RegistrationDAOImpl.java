package com.chainsys.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.trainingproject.dao.RegistrationDAO;
import com.chainsys.trainingproject.logger.Logger;
import com.chainsys.trainingproject.model.Registration;
import com.chainsys.util.DbConnection;
import com.chainsys.util.DbException;

public class RegistrationDAOImpl implements RegistrationDAO {
	private static final Logger log = Logger.getInstance();

	public void addUserDetails(Registration reg) throws DbException {

		String sql = "insert into registration(user_id,user_name,user_password,user_city,mobile_no,mail_id,qualification,gender) values(user_id_seq.nextval,?,?,?,?,?,?,?)";
		log.getInput(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, reg.getUserName());
			stmt.setString(2, reg.getUserPassword());
			stmt.setString(3, reg.getUserCity());
			stmt.setLong(4, reg.getMobileNo());
			stmt.setString(5, reg.getMailId());
			stmt.setString(6, reg.getQualification());
			stmt.setString(7, reg.getGender());
			int row = stmt.executeUpdate();
			log.getInput(row);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void updateUserDetails(int userId, long mobileNo) throws DbException {

		String sql = "update registration set mobile_no=? where user_id=?";
		log.getInput(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setLong(1, mobileNo);
			pst.setInt(2, userId);
			int row = pst.executeUpdate();
			log.getInput(row);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public List<Registration> allUserDetails() throws DbException {

		List<Registration> list1 = new ArrayList<Registration>();
		String sql = "select * from registration";
		log.getInput("***Display User Details***");
		log.getInput(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Registration reg = new Registration();
					reg.setUserId(rs.getInt("user_id"));
					reg.setUserName(rs.getString("user_name"));
					reg.setUserPassword(rs.getString("user_password"));
					reg.setUserCity(rs.getString("user_city"));
					reg.setMobileNo(rs.getLong("mobile_no"));
					reg.setMailId(rs.getString("mail_id"));
					reg.setQualification(rs.getString("qualification"));
					reg.setGender(rs.getString("gender"));
					list1.add(reg);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return list1;
	}

	public void deleteUserDetails(int userId) throws DbException {

		String sql = "delete from registration where user_id=?";
		log.getInput(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userId);
			int row = pst.executeUpdate();
			log.getInput(row);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public int getNoOfUsers() throws DbException {

		String sql = "select count(user_id) from registration";
		log.getInput("***Display the No of Users***");
		log.getInput(sql);
		int a = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					a = rs.getInt("count(user_id)");
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return a;
	}

	public List<Registration> getDegreeWiseNoOfUsers() throws DbException {

		List<Registration> list1 = new ArrayList<Registration>();
		String sql = "select qualification as qualification,count(user_id) from registration group by qualification";
		log.getInput("***Display No Of Users Based on Qualification***");
		log.getInput(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Registration reg = new Registration();
					reg.setUserId(rs.getInt("count(user_id)"));
					reg.setQualification(rs.getString("qualification"));
					list1.add(reg);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return list1;
	}
}