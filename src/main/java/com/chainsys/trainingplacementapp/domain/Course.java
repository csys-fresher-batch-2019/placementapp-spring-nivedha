package com.chainsys.trainingplacementapp.domain;

public class Course {

	private int courseId;
	private String courseName;
	private int courseDuration;
	private int courseFees;
	private int courseCount;
	private String courseImage;
	private String coursePdf;

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

	public int getCourseCount() {
		return courseCount;
	}

	public void setCourseCount(int courseCount) {
		this.courseCount = courseCount;
	}

	public String getCourseImage() {
		return courseImage;
	}

	public void setCourseImage(String courseImage) {
		this.courseImage = courseImage;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ ", courseFees=" + courseFees + "]";
	}

	public String getCoursePdf() {
		return coursePdf;
	}

	public void setCoursePdf(String coursePdf) {
		this.coursePdf = coursePdf;
	}

}
