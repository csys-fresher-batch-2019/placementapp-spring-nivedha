package com.chainsys.trainingplacementapp.domain;

import java.time.LocalDateTime;

public class Comments {

	private int commentsId;
	private int userCourseId;
	private String courseComments;
	private int institutionRating;
	private LocalDateTime createdDate;

	public int getCommentsId() {
		return commentsId;
	}

	public void setCommentsId(int commentsId) {
		this.commentsId = commentsId;
	}

	public int getUserCourseId() {
		return userCourseId;
	}

	public int setUserCourseId(int userCourseId) {
		return this.userCourseId = userCourseId;
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
		return "Comments [commentsId=" + commentsId + ", userId=" + userCourseId + ", userName=" + ", courseComments=" + courseComments + ", institutionRating=" + institutionRating +
				 ", createdDate=" + createdDate + "]";
	}
}
