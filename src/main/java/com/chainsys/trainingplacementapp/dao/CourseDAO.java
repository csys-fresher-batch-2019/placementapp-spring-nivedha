package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.Course;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface CourseDAO {

	void addCourses(Course list) throws DbException;

	List<Course> allCourseDetails(String courseName) throws DbException;

	void updateCourse(String courseName, int courseFees) throws DbException;

	int getFees(String courseName) throws DbException;

	void deleteCourse(int courseId) throws DbException;

	List<Course> getCourseNames() throws DbException;

	List<Course> getNamesByfeesRange(int fees1, int fees2) throws DbException;

	List<Course> getMinFeesCourses() throws DbException;

}
