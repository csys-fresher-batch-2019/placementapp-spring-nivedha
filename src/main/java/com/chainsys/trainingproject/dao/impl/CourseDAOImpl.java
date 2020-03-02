package com.chainsys.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.trainingproject.dao.CourseDAO;
import com.chainsys.trainingproject.logger.Logger;
import com.chainsys.trainingproject.model.Course;
import com.chainsys.util.DbConnection;
import com.chainsys.util.DbException;

public class CourseDAOImpl implements CourseDAO {
	private static final Logger log = Logger.getInstance();

	public List<Course> allCourseDetails(String courseName) throws DbException {

		List<Course> list = new ArrayList<Course>();
		String sql = "select course_id,course_name,course_duration,course_fees,course_image,course_pdf from course where course_name=?";
		log.getInput("***Display Course Details By Name***");
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
			log.error(e);
		}
		return list;
	}

	public void updateCourse(String courseName, int courseFees) throws DbException {

		String sql = "update course set course_fees=? where course_name=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, courseFees);
			pst.setString(2, courseName);
			int row = pst.executeUpdate();
		} catch (Exception e) {
			log.error(e);
		}
	}

	public int getFees(String courseName) throws DbException {

		String sql = "select course_fees from course where course_name=?";
		log.getInput("***Display " + courseName + " Fees Details***");
		int a = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, courseName);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					a = rs.getInt("course_fees");
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return a;
	}

	public List<Course> getCourseNames() throws DbException {

		List<Course> list = new ArrayList<Course>();
		String sql = "select course_name from course";
		log.getInput("***Display All Course Names***");
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {

				while (rs.next()) {
					Course c = new Course();
					c.setCourseName(rs.getString("course_name"));
					list.add(c);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}

	public void deleteCourse(int courseId) throws DbException {

		String sql = "delete from course where course_id=?";
		log.getInput("***Delete " + courseId + " Details***");
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, courseId);
			int row = pst.executeUpdate();
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void addCourses(Course cl) throws DbException {

		String sql = "insert into course(course_id,course_name,course_duration,course_fees,course_pdf,course_image)values(course_id_seq.nextval,?,?,?,?,?)";
		log.getInput("***Add Course Details***");
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, cl.getCourseName());
			pst.setInt(2, cl.getCourseDuration());
			pst.setInt(3, cl.getCourseFees());
			pst.setString(4, cl.getCoursePdf());
			pst.setString(5, cl.getCourseImage());
			int row = pst.executeUpdate();
		} catch (Exception e) {
			log.error(e);
		}
	}

	public List<Course> getNamesByfeesRange(int fees1, int fees2) throws DbException {

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
			log.error(e);
		}
		return list;
	}

	public List<Course> getMinFeesCourses() throws DbException {

		List<Course> list = new ArrayList<Course>();
		String sql = "select course_name,course_fees from course where course_fees=(select min(course_fees) from course)";
		log.getInput("");
		log.getInput("***Display the Minimum Course Fees Names***");
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
			log.error(e);
		}
		return list;
	}
}
