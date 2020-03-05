package com.chainsys.trainingplacementapp.domain;

import java.time.LocalDate;

public class JoinUserCourse {

	private  int courseId; 
	private  String courseName;
	private  int courseDuration;
	private  int courseFees;
	private  int userId;
	private  LocalDate startDate;
	private  LocalDate completionDate;
	private double totalAmount;
	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	public int getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(int courseFees) {
		this.courseFees = courseFees;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "JoinUserCourse [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration="
				+ courseDuration + ", courseFees=" + courseFees + ", userId=" + userId + ", startDate=" + startDate + ", completionDate="
				+ completionDate + ", totalAmount=" + totalAmount + "]";
	}
	
}
