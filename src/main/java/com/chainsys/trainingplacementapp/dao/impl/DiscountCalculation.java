package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ErrorConstant;
import com.chainsys.trainingplacementapp.util.DbConnection;

public class DiscountCalculation {

	private static final Logger logger = LoggerFactory.getLogger(DiscountCalculation.class);

	public int count(int userId) throws DbException {

		String sql = "select count(user_id) from usercourse where user_id=?";
		logger.info("***Display " + userId + " count***");
		logger.info(sql);
		int a = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					a = rs.getInt("count(user_id)");
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return a;
	}

	public int findFeesByCourseId(int courseId) throws DbException {

		String sql = "select course_fees from course where course_id=?";
		logger.info("");
		logger.info("***Display " + courseId + " Fees Details***");
		logger.info(sql);
		int a = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, courseId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					a = rs.getInt("course_fees");
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return a;
	}
}