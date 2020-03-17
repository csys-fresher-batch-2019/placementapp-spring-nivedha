package com.chainsys.trainingplacementapp.domain;

public class InterviewPerformance {

	private int performId;
	private int clientId;
	private int userId;
	private String interviewStatus;
	private int marks;

	public int getPerformId() {
		return performId;
	}

	public void setPerformId(int performId) {
		this.performId = performId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}


	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "InterviewPerformance [performId=" + performId + ", clientId=" + clientId + ", userId=" + userId
				+ ", interStatus=" + interviewStatus + ", marks=" + marks + "]";
	}

}
