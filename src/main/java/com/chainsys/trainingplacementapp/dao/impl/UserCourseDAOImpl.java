package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.trainingplacementapp.dao.UserCourseDAO;
import com.chainsys.trainingplacementapp.domain.UserCourse;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;

public class UserCourseDAOImpl implements UserCourseDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserCourseDAOImpl.class);

	public void save(UserCourse uc) throws DbException {

		String sql = "insert into usercourse"
				+ "(user_course_id,user_id,course_id,start_date,completion_date,total_amount)"
				+ "values (user_course_id_seq.nextval,?,?,?,?,?)";
		logger.info("");
		logger.info("***Add Course Duration Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, uc.getUserId());
			pst.setInt(2, uc.getCourseId());
			pst.setDate(3, Date.valueOf(uc.getStartDate()));
			pst.setDate(4, Date.valueOf(uc.getCompletionDate()));
			pst.setDouble(5, uc.getTotalAmount());
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (Exception e) {
			throw new DbException("Unable to Add User Course Details", e);
		}
	}

	public int findCourseDurationByCourseId(int courseId) throws DbException {
		String sql = "select course_duration from course where course_id =?";
		logger.info("" + courseId);
		logger.info("***Display Course Duration Details***");
		int courseDuration = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, courseId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					courseDuration = rs.getInt("course_duration");
				}
			}
		} catch (Exception e) {
			throw new DbException("Unable to Find Course Duration", e);
		}
		return courseDuration;
	}

	public List<UserCourse> findAllByUserId(int userId) throws DbException {

		List<UserCourse> list1 = new ArrayList<UserCourse>();
		String sql = "select user_course_id,user_id,course_id,start_date,completion_date,total_amount from usercourse where user_id=?";
		logger.info("***Display UserCourse Details***");
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userId);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					UserCourse ucc = new UserCourse();
					ucc.setUserCourseId(rs.getInt("user_course_id"));
					ucc.setUserId(rs.getInt("user_id"));
					ucc.setCourseId(rs.getInt("course_id"));
					Date d = rs.getDate("start_date");
					if (d != null) {
						LocalDate ld = d.toLocalDate();
						ucc.setStartDate(ld);
					}
					Date d1 = rs.getDate("completion_date");
					if (d1 != null) {
						LocalDate ld1 = d1.toLocalDate();
						ucc.setCompletionDate(ld1);
					}
					ucc.setTotalAmount(rs.getDouble("total_amount"));
					list1.add(ucc);
				}
			}
		} catch (Exception e) {
			throw new DbException("Unable to Find User Course Details", e);
		}
		return list1;
	}
}