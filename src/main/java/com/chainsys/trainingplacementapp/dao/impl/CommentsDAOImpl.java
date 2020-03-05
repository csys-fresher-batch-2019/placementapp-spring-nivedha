package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chainsys.trainingplacementapp.dao.CommentsDAO;
import com.chainsys.trainingplacementapp.domain.Comments;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;
import com.chainsys.trainingplacementapp.util.Logger;

public class CommentsDAOImpl implements CommentsDAO {
	private static final Logger log = Logger.getInstance();

	public void addComments(Comments c) throws DbException {

		String sql = "insert into comments(comments_id,user_course_id,trainer_id,course_comments,institution_rating,trainer_rating)"
				+ "values(comments_id_sqn.nextval,?,?,?,?,?)";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, c.getUserCourseId());
			pst.setInt(2, c.getTrainerId());
			pst.setString(3, c.getCourseComments());
			pst.setInt(4, c.getInstitutionRating());
			pst.setInt(5, c.getTrainerRating());
			int row = pst.executeUpdate();
			log.getInput("***Comments Added successfully***");
		} catch (Exception e) {
			log.error(e);
		}
	}

	public String getUserName(int userCourseId) throws DbException {
		String sql = "select user_name from registration where user_id=(select user_id from usercourse where user_course_id=?)";
		String a = null;
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setInt(1, userCourseId);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					a = rs.getString("user_name");
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return a;
	}

	public String getCourseName(int userCourseId) throws DbException {
		String sql = "select course_name from course where course_id=(select course_id from usercourse where user_course_id=?)";
		String a = null;
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setInt(1, userCourseId);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					a = rs.getString("course_name");
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return a;
	}

	public String getTrainerName(int trainerId) throws DbException {
		String sql = "select trainer_name from trainer where trainer_id=?";
		String b = null;
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setInt(1, trainerId);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					b = rs.getString("trainer_name");
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return b;
	}
}
