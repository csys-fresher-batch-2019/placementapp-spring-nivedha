package com.chainsys.trainingplacementapp.domain;

import java.time.LocalDate;
import java.util.Date;

public class UserCourse {

	private  int userCourseId;
	private  int userId;
	private  int courseId;
	private  LocalDate startDate;
	private  LocalDate completionDate;
	private double totalAmount;
	
	public int getUserCourseId() {
		return userCourseId;
	}

	public void setUserCourseId(int userCourseId) {
		this.userCourseId = userCourseId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
		return "UserCourse [userCourseId=" + userCourseId + ", userId=" + userId + ", courseId=" + courseId
				+ ", startDate=" + startDate + ", completionDate=" + completionDate + ", totalAmount=" + totalAmount + "]";
	} 
}
