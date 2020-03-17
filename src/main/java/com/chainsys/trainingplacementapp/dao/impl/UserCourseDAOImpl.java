package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.trainingplacementapp.dao.UserCourseDAO;
import com.chainsys.trainingplacementapp.domain.UserCourse;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;
@Repository
public class UserCourseDAOImpl implements UserCourseDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserCourseDAOImpl.class);

	public void save(UserCourse userCourse) throws DbException {

		String sql = "insert into usercourse"
				+ "(user_course_id,user_id,course_id,start_date,completion_date,total_amount)"
				+ "values (user_course_id_seq.nextval,?,?,?,?,?)";
		logger.info("");
		logger.info("***Add Course Duration Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userCourse.getUserId());
			pst.setInt(2, userCourse.getCourseId());
			pst.setDate(3, Date.valueOf(userCourse.getStartDate()));
			pst.setDate(4, Date.valueOf(userCourse.getCompletionDate()));
			pst.setDouble(5, userCourse.getTotalAmount());
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
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
		} catch (SQLException e) {
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
					UserCourse userCourse = new UserCourse();
					userCourse.setUserCourseId(rs.getInt("user_course_id"));
					userCourse.setUserId(rs.getInt("user_id"));
					userCourse.setCourseId(rs.getInt("course_id"));
					Date d = rs.getDate("start_date");
					if (d != null) {
						LocalDate ld = d.toLocalDate();
						userCourse.setStartDate(ld);
					}
					Date d1 = rs.getDate("completion_date");
					if (d1 != null) {
						LocalDate ld1 = d1.toLocalDate();
						userCourse.setCompletionDate(ld1);
					}
					userCourse.setTotalAmount(rs.getDouble("total_amount"));
					list1.add(userCourse);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find User Course Details", e);
		}
		return list1;
	}
}