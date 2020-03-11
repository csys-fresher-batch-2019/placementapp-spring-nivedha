package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.trainingplacementapp.dao.CourseDAO;
import com.chainsys.trainingplacementapp.domain.Course;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ErrorConstant;
import com.chainsys.trainingplacementapp.util.DbConnection;

public class CourseDAOImpl implements CourseDAO {
	private static final Logger logger = LoggerFactory.getLogger(CourseDAOImpl.class);

	public List<Course> findByCourseName(String courseName) throws DbException {

		List<Course> list = new ArrayList<Course>();
		String sql = "select course_id,course_name,course_duration,course_fees,course_image,course_pdf from course where course_name=?";
		logger.info("***Display Course Details By Name***");
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, courseName);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Course c = new Course();
					c.setCourseId(rs.getInt("course_id"));
					c.setCourseName(rs.getString("course_name"));
					c.setCourseDuration(rs.getInt("course_duration"));
					c.setCourseFees(rs.getInt("course_fees"));
					c.setCoursePdf(rs.getString("course_pdf"));
					c.setCourseImage(rs.getString("course_image"));
					list.add(c);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	public void update(String courseName, int courseFees) throws DbException {

		String sql = "update course set course_fees=? where course_name=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, courseFees);
			pst.setString(2, courseName);
			int row = pst.executeUpdate();
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_UPDATE);
		}
	}

	public int findCourseFeesByCourseName(String courseName) throws DbException {

		String sql = "select course_fees from course where course_name=?";
		logger.info("***Display " + courseName + " Fees Details***");
		int a = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, courseName);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					a = rs.getInt("course_fees");
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		return a;
	}

	public List<Course> findCourseNames() throws DbException {

		List<Course> list = new ArrayList<Course>();
		String sql = "select course_name from course";
		logger.info("***Display All Course Names***");
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {

				while (rs.next()) {
					Course c = new Course();
					c.setCourseName(rs.getString("course_name"));
					list.add(c);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}

	public void delete(int courseId) throws DbException {

		String sql = "delete from course where course_id=?";
		logger.info("***Delete " + courseId + " Details***");
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, courseId);
			int row = pst.executeUpdate();
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_DELETE);

		}
	}

	public void save(Course cl) throws DbException {

		String sql = "insert into course(course_id,course_name,course_duration,course_fees,course_pdf,course_image)values(course_id_seq.nextval,?,?,?,?,?)";
		logger.info("***Add Course Details***");
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, cl.getCourseName());
			pst.setInt(2, cl.getCourseDuration());
			pst.setInt(3, cl.getCourseFees());
			pst.setString(4, cl.getCoursePdf());
			pst.setString(5, cl.getCourseImage());
			int row = pst.executeUpdate();
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_ADD);

		}
	}

	public List<Course> findCourseNamesByFees(int fees1, int fees2) throws DbException {

		List<Course> list = new ArrayList<Course>();
		String sql = "select course_name,course_fees from course where course_fees between ? and ?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, fees1);
			pst.setInt(2, fees2);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Course c = new Course();
					c.setCourseName(rs.getString("course_name"));
					c.setCourseFees(rs.getInt("course_fees"));
					list.add(c);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}

	public List<Course> findCourseNamesByMinFees() throws DbException {

		List<Course> list = new ArrayList<Course>();
		String sql = "select course_name,course_fees from course where course_fees=(select min(course_fees) from course)";
		logger.info("");
		logger.info("***Display the Minimum Course Fees Names***");
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Course c = new Course();
					c.setCourseName(rs.getString("course_name"));
					c.setCourseFees(rs.getInt("course_fees"));
					list.add(c);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}
}
