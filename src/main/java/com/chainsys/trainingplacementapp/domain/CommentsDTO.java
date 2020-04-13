package com.chainsys.trainingplacementapp.domain;

import java.time.LocalDateTime;

public class CommentsDTO {
	
	private int userCourseId;
	private String userName;
	private String courseName;
	private String courseComments;
	private int institutionRating;
	private LocalDateTime createdDate;
	private String profile;

	
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
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "CommentsDTO [userCourseId=" + userCourseId + ", userName=" + userName + ",profile=" + profile + ", courseName=" + courseName
				+ ", courseComments=" + courseComments + ", institutionRating=" + institutionRating + ", createdDate="
				+ createdDate + "]";
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	

}
