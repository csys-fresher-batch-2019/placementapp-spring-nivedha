package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;

public class DiscountCalculation {

	private static final Logger logger = LoggerFactory.getLogger(DiscountCalculation.class);

	public int count(int userId) throws DbException {

		String sql = "select count(user_id) from usercourse where user_id=?";
		logger.info("***Display " + userId + " count***");
		logger.info(sql);
		int count = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					count = rs.getInt("count(user_id)");
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to count UserCourse Details",e);
		}
		return count;
	}

	public int findFeesByCourseId(int courseId) throws DbException {

		String sql = "select course_fees from course where course_id=?";
		logger.info("");
		logger.info("***Display " + courseId + " Fees Details***");
		logger.info(sql);
		int courseFees = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, courseId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					courseFees = rs.getInt("course_fees");
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Course Fees",e);
		}
		return courseFees;
	}
}