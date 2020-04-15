package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.trainingplacementapp.dao.RegistrationDAO;
import com.chainsys.trainingplacementapp.domain.Registration;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;

@Repository
public class RegistrationDAOImpl implements RegistrationDAO {
	private static final Logger logger = LoggerFactory.getLogger(RegistrationDAOImpl.class);

	public int save(Registration registration) throws DbException {
		int row = 0;
		String sql = "insert into registration(user_id,user_name,user_password,user_city,mobile_no,mail_id,qualification,gender,profile) values(user_id_seq.nextval,?,?,?,?,?,?,?,?)";
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, registration.getUserName());
			pst.setString(2, registration.getUserPassword());
			pst.setString(3, registration.getUserCity());
			pst.setLong(4, registration.getMobileNo());
			pst.setString(5, registration.getMailId());
			pst.setString(6, registration.getQualification());
			pst.setString(7, registration.getGender());
			pst.setString(8, registration.getProfile());
			row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
			throw new DbException("Unable to Add User Details", e);
		}
		return row;
	}

	public List<Registration> findAll() throws DbException {

		List<Registration> list1 = new ArrayList<Registration>();
		String sql = "select * from registration";
		logger.info("***Display User Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Registration registration = new Registration();
					registration.setUserId(rs.getInt("user_id"));
					registration.setUserName(rs.getString("user_name"));
					registration.setUserPassword(rs.getString("user_password"));
					registration.setUserCity(rs.getString("user_city"));
					registration.setMobileNo(rs.getLong("mobile_no"));
					registration.setMailId(rs.getString("mail_id"));
					registration.setQualification(rs.getString("qualification"));
					registration.setGender(rs.getString("gender"));
					registration.setProfile(rs.getString("profile"));
					list1.add(registration);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find User Details", e);
		}
		return list1;
	}

	public void delete(int userId) throws DbException {

		String sql = "delete from registration where user_id=?";
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userId);
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
			throw new DbException("Unable to Delete User Details", e);
		}
	}

	public int count() throws DbException {

		String sql = "select count(user_id) from registration";
		logger.info("***Display the No of Users***");
		logger.info(sql);
		int count = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					count = rs.getInt("count(user_id)");
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Count User Details", e);
		}
		return count;
	}

	public List<Registration> findQualificationAndCount() throws DbException {

		List<Registration> list1 = new ArrayList<Registration>();
		String sql = "select qualification as qualification,count(user_id) from registration group by qualification";
		logger.info("***Display No Of Users Based on Qualification***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Registration registration = new Registration();
					registration.setUserId(rs.getInt("count(user_id)"));
					registration.setQualification(rs.getString("qualification"));
					list1.add(registration);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find User Qualification Details", e);
		}
		return list1;
	}

	@Override
	public List<Registration> findByUserId(int userId) throws DbException {
		List<Registration> list1 = new ArrayList<Registration>();
		String sql = "select * from registration where user_id=?";
		logger.info("***Display User Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userId);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Registration registration = new Registration();
					registration.setUserId(rs.getInt("user_id"));
					registration.setUserName(rs.getString("user_name"));
					registration.setUserPassword(rs.getString("user_password"));
					registration.setUserCity(rs.getString("user_city"));
					registration.setMobileNo(rs.getLong("mobile_no"));
					registration.setMailId(rs.getString("mail_id"));
					registration.setQualification(rs.getString("qualification"));
					registration.setGender(rs.getString("gender"));
					registration.setProfile(rs.getString("profile"));
					list1.add(registration);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find User Details", e);
		}
		return list1;
	}

	@Override
	public void update(String userName, String mailId, String password, String profile, String userCity, long mobileNo,
			String qualification, String gender, int userId) throws DbException {
		String sql = "update registration set user_name=?,mail_id=?,user_password=?,profile=?,user_city=?,mobile_no=?,qualification=?,gender=? where user_id=?";
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, userName);
			pst.setString(2, mailId);
			pst.setString(3, password);
			pst.setString(4, profile);
			pst.setString(5, userCity);
			pst.setLong(6, mobileNo);
			pst.setString(7, qualification);
			pst.setString(8, gender);
			pst.setInt(9, userId);
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
			throw new DbException("Unable to Update User Details", e);
		}
	}
}