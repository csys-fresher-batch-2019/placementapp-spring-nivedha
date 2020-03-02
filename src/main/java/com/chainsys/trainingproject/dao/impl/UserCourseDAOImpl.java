package com.chainsys.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.trainingproject.dao.UserCourseDAO;
import com.chainsys.trainingproject.logger.Logger;
import com.chainsys.trainingproject.model.UserCourse;
import com.chainsys.util.DbConnection;
import com.chainsys.util.DbException;

public class UserCourseDAOImpl implements UserCourseDAO {
	private static final Logger log = Logger.getInstance();

	public void addCourseDurationDate(UserCourse uc) throws DbException {

		String sql = "insert into usercourse"
				+ "(user_course_id,user_id,course_id,start_date,completion_date,total_amount)"
				+ "values (user_course_id_seq.nextval,?,?,?,?,?)";
		log.getInput("");
		log.getInput("***Add Course Duration Details***");
		log.getInput(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, uc.getUserId());
			pst.setInt(2, uc.getCourseId());
			pst.setDate(3, Date.valueOf(uc.getStartDate()));
			pst.setDate(4, Date.valueOf(uc.getCompletionDate()));
			pst.setDouble(5, uc.getTotalAmount());
			int row = pst.executeUpdate();
			log.getInput(row);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public int getDuration(int courseId) throws DbException {
		String sql = "select course_duration from course where course_id =?";
		log.getInput(courseId);
		log.getInput("***Display Course Duration Details***");
		int a = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, courseId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					a = rs.getInt("course_duration");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return a;
	}

	public List<UserCourse> getUserCourseDetails(int userId) throws DbException {

		List<UserCourse> list1 = new ArrayList<UserCourse>();
		String sql = "select * from usercourse where user_id=?";
		log.getInput("***Display UserCourse Details***");
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
			e.printStackTrace();
			log.error(e);
		}
		return list1;
	}
}