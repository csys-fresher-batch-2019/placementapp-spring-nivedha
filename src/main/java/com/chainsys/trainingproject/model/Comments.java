package com.chainsys.trainingproject.model;

import java.time.LocalDateTime;

public class Comments {

	private int commentsId;
	private int userCourseId;
	private String userName;
	private String courseName;
	private int trainerId;
	private String trainerName;
	private String courseComments;
	private int institutionRating;
	private int trainerRating;
	private LocalDateTime currentDate;
	
	public int getCommentsId() {
		return commentsId;
	}
	public void setCommentsId(int commentsId) {
		this.commentsId = commentsId;
	}
	public int getUserCourseId() {
		return userCourseId;
	}
	public void setUserCourseId(int userCourseId) {
		this.userCourseId = userCourseId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getCourseComments() {
		return courseComments;
	}
	public void setCourseComments(String courseComments) {
		this.courseComments = courseComments;
	}
	public int getInstitutionRating() {
		return institutionRating;
	}
	public void setInstitutionRating(int institutionRating) {
		this.institutionRating = institutionRating;
	}
	public int getTrainerRating() {
		return trainerRating;
	}
	public void setTrainerRating(int trainerRating) {
		this.trainerRating = trainerRating;
	}
	public LocalDateTime getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(LocalDateTime currentDate) {
		this.currentDate = currentDate;
	}
	@Override
	public String toString() {
		return "Comments [commentsId=" + commentsId + ", userId=" + userCourseId + ", userName=" + userName + ", courseName="
				+ courseName + ", trainerId=" + trainerId + ", trainerName=" + trainerName + ", courseComments="
				+ courseComments + ", institutionRating=" + institutionRating + ", trainerRating=" + trainerRating
				+ ", currentDate=" + currentDate + "]";
	}
}
