package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.trainingplacementapp.dao.RegistrationDAO;
import com.chainsys.trainingplacementapp.domain.Registration;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ErrorConstant;
import com.chainsys.trainingplacementapp.util.DbConnection;
@Repository
public class RegistrationDAOImpl implements RegistrationDAO {
	private static final Logger logger = LoggerFactory.getLogger(RegistrationDAOImpl.class);

	public int save(Registration reg) throws DbException {
       int row = 0;
		String sql = "insert into registration(user_id,user_name,user_password,user_city,mobile_no,mail_id,qualification,gender) values(user_id_seq.nextval,?,?,?,?,?,?,?)";
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, reg.getUserName());
			stmt.setString(2, reg.getUserPassword());
			stmt.setString(3, reg.getUserCity());
			stmt.setLong(4, reg.getMobileNo());
			stmt.setString(5, reg.getMailId());
			stmt.setString(6, reg.getQualification());
			stmt.setString(7, reg.getGender());
			 row = stmt.executeUpdate();
			logger.info(""+row);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_ADD);
		}
		return row;
	}

	public void update(int userId, long mobileNo) throws DbException {

		String sql = "update registration set mobile_no=? where user_id=?";
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setLong(1, mobileNo);
			pst.setInt(2, userId);
			int row = pst.executeUpdate();
			logger.info(""+row);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_UPDATE);
		}
	}

	public List<Registration> findAll() throws DbException {

		List<Registration> list1 = new ArrayList<Registration>();
		String sql = "select * from registration";
		logger.info("***Display User Details***");
		logger.info(sql);
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
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		return list1;
	}

	public void delete(int userId) throws DbException {

		String sql = "delete from registration where user_id=?";
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userId);
			int row = pst.executeUpdate();
			logger.info(""+row);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_DELETE);

		}
	}

	public int count() throws DbException {

		String sql = "select count(user_id) from registration";
		logger.info("***Display the No of Users***");
		logger.info(sql);
		int a = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					a = rs.getInt("count(user_id)");
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return a;
	}

	public List<Registration> findQualificationAndCount() throws DbException {

		List<Registration> list1 = new ArrayList<Registration>();
		String sql = "select qualification as qualification,count(user_id) from registration group by qualification";
		logger.info("***Display No Of Users Based on Qualification***");
		logger.info(sql);
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
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return list1;
	}
}