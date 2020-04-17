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

import com.chainsys.trainingplacementapp.dao.CommentsDAO;
import com.chainsys.trainingplacementapp.domain.Comments;
import com.chainsys.trainingplacementapp.domain.CommentsDTO;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;
@Repository
public class CommentsDAOImpl implements CommentsDAO {
	private static final Logger logger = LoggerFactory.getLogger(CommentsDAOImpl.class);

	public void save(Comments c) throws DbException {

		String sql = "insert into comments(comments_id,user_course_id,course_comments,institution_rating)"
				+ "values(comments_id_sqn.nextval,?,?,?)";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, c.getUserCourseId());
			pst.setString(2, c.getCourseComments());
			pst.setInt(3, c.getInstitutionRating());
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

	@Override
	public List<CommentsDTO> findComments() throws DbException {
		List<CommentsDTO> list = new ArrayList<CommentsDTO>();
		String sql = "select cm.user_course_id,r.user_name,r.profile,r.gender,c.course_name,cm.course_comments,cm.institution_rating,cm.created_date \r\n"
				+ "from course c,registration r,comments cm,usercourse uc where c.course_id=uc.course_id and r.user_id=uc.user_id and cm.user_course_id=uc.user_course_id";
		logger.info("***Display All UserCourse Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					CommentsDTO c = new CommentsDTO();
					c.setUserCourseId(rs.getInt("user_course_id"));
					c.setUserName(rs.getString("user_name"));
					c.setProfile(rs.getString("profile"));
					c.setGender(rs.getString("gender"));
					c.setCourseName(rs.getString("course_name"));
					c.setCourseComments(rs.getString("course_comments"));
					c.setInstitutionRating(rs.getInt("institution_rating"));
					c.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
					list.add(c);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find User Comments", e);
		}
		return list;
	}

}
