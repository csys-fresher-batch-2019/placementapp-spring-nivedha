package com.chainsys.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chainsys.trainingproject.logger.Logger;

public class DiscountCalculation {

	private static final Logger log = Logger.getInstance();

	public int getNoOfUser(int userId) throws DbException {

		String sql = "select count(user_id) from usercourse where user_id=?";
		log.getInput("");
		log.getInput("***Display " + userId + " count***");
		log.getInput(sql);
		int a = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					a = rs.getInt("count(user_id)");
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return a;
	}

	public int getCourseFees(int courseId) throws DbException {

		String sql = "select course_fees from course where course_id=?";
		log.getInput("");
		log.getInput("***Display " + courseId + " Fees Details***");
		log.getInput(sql);
		int a = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, courseId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					a = rs.getInt("course_fees");
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return a;
	}
}