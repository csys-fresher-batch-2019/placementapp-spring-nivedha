package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.trainingplacementapp.dao.CommentsDAO;
import com.chainsys.trainingplacementapp.domain.Comments;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;

public class CommentsDAOImpl implements CommentsDAO {
	private static final Logger logger = LoggerFactory.getLogger(CommentsDAOImpl.class);

	public void save(Comments c) throws DbException {

		String sql = "insert into comments(comments_id,user_course_id,trainer_id,course_comments,institution_rating,trainer_rating)"
				+ "values(comments_id_sqn.nextval,?,?,?,?,?)";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, c.getUserCourseId());
			pst.setInt(2, c.getTrainerId());
			pst.setString(3, c.getCourseComments());
			pst.setInt(4, c.getInstitutionRating());
			pst.setInt(5, c.getTrainerRating());
			int row = pst.executeUpdate();
			logger.info("" + row);
			logger.info("***Comments Added successfully***");
		} catch (SQLException e) {
			throw new DbException("Unable to Add Comments", e);
		}
	}

	public String findUserNameByUserCourseId(int userCourseId) throws DbException {
		String sql = "select user_name from registration where user_id=(select user_id from usercourse where user_course_id=?)";
		String userName = null;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userCourseId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					userName = rs.getString("user_name");
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find UserName", e);
		}
		return userName;
	}

	public String findCourseNameByUserCourseId(int userCourseId) throws DbException {
		String sql = "select course_name from course where course_id=(select course_id from usercourse where user_course_id=?)";
		String courseName = null;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userCourseId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					courseName = rs.getString("course_name");
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Course Name", e);
		}
		return courseName;
	}

	public String findTrainerNameById(int trainerId) throws DbException {
		String sql = "select trainer_name from trainer where trainer_id=?";
		String TrainerName = null;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, trainerId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					TrainerName = rs.getString("trainer_name");
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Trainer Name", e);
		}
		return TrainerName;
	}
}
