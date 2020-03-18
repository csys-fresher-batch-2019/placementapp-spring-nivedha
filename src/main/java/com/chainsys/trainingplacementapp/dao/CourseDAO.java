package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.Course;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface CourseDAO {

	void save(Course course) throws DbException;

	List<Course> findByCourseName(String courseName) throws DbException;

	void update(String courseName, int courseFees) throws DbException;

	int findCourseFeesByCourseName(String courseName) throws DbException;

	void delete(int courseId) throws DbException;

	List<Course> findCourseNames() throws DbException;

	List<Course> findCourseNamesByFees(int fees1, int fees2) throws DbException;

	List<Course> findCourseNamesByMinFees() throws DbException;

}
