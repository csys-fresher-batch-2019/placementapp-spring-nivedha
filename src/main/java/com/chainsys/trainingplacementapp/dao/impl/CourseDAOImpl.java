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

import com.chainsys.trainingplacementapp.dao.CourseDAO;
import com.chainsys.trainingplacementapp.domain.Course;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;
@Repository
public class CourseDAOImpl implements CourseDAO {
	private static final Logger logger = LoggerFactory.getLogger(CourseDAOImpl.class);

	public List<Course> findByCourseName(String courseName) throws DbException {

		List<Course> list = new ArrayList<Course>();
		String sql = "select course_id,course_name,course_duration,course_fees,course_image,course_pdf from course where course_name=?";
		logger.info("***Display Course Details By Name***");
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, courseName);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Course course = new Course();
					course.setCourseId(rs.getInt("course_id"));
					course.setCourseName(rs.getString("course_name"));
					course.setCourseDuration(rs.getInt("course_duration"));
					course.setCourseFees(rs.getInt("course_fees"));
					course.setCoursePdf(rs.getString("course_pdf"));
					course.setCourseImage(rs.getString("course_image"));
					list.add(course);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Course Details", e);
		}
		return list;
	}

	public void update(String courseName, int courseFees) throws DbException {

		String sql = "update course set course_fees=? where course_name=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, courseFees);
			pst.setString(2, courseName);
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
			throw new DbException("Unable to Update Course Fees", e);
		}
	}

	public int findCourseFeesByCourseName(String courseName) throws DbException {

		String sql = "select course_fees from course where course_name=?";
		logger.info("***Display " + courseName + " Fees Details***");
		int courseFees = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, courseName);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					courseFees = rs.getInt("course_fees");
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Course Fees", e);
		}
		return courseFees;
	}

	public List<Course> findCourseNames() throws DbException {

		List<Course> list = new ArrayList<Course>();
		String sql = "select course_name from course";
		logger.info("***Display All Course Names***");
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					Course course = new Course();
					course.setCourseName(rs.getString("course_name"));
					list.add(course);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Course Name", e);
		}
		return list;
	}

	public void delete(int courseId) throws DbException {

		String sql = "delete from course where course_id=?";
		logger.info("***Delete " + courseId + " Details***");
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, courseId);
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
			throw new DbException("Unable to Delete Course Details", e);
		}
	}

	public void save(Course course) throws DbException {

		String sql = "insert into course(course_id,course_name,course_duration,course_fees,course_pdf,course_image)values(course_id_seq.nextval,?,?,?,?,?)";
		logger.info("***Add Course Details***");
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, course.getCourseName());
			pst.setInt(2, course.getCourseDuration());
			pst.setInt(3, course.getCourseFees());
			pst.setString(4, course.getCoursePdf());
			pst.setString(5, course.getCourseImage());
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
			throw new DbException("Unable to Add Course Details", e);
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
					Course course = new Course();
					course.setCourseName(rs.getString("course_name"));
					course.setCourseFees(rs.getInt("course_fees"));
					list.add(course);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Course Name and Fees", e);
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
					Course course = new Course();
					course.setCourseName(rs.getString("course_name"));
					course.setCourseFees(rs.getInt("course_fees"));
					list.add(course);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Minimum Course Fees", e);
		}
		return list;
	}
}
