package com.chainsys.trainingplacementapp.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class InterviewSchedule {

	private int interviewId;
	private int clientId;
	private String jobTitle;
	private String jobRequirement;
	private LocalDate createdDate;
	private LocalDate interviewDate;

	public int getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobRequirement() {
		return jobRequirement;
	}

	public void setJobRequirement(String jobRequirement) {
		this.jobRequirement = jobRequirement;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(LocalDate interviewDate) {
		this.interviewDate = interviewDate;
	}

	public LocalTime getInterviewTime() {
		return interviewTime;
	}

	public void setInterviewTime(LocalTime interviewTime) {
		this.interviewTime = interviewTime;
	}

	private LocalTime interviewTime;

	@Override
	public String toString() {
		return "InterviewSchedule [interviewId=" + interviewId + ", clientId=" + clientId + ", jobTitle=" + jobTitle
				+ ", jobRequirement=" + jobRequirement + ", createdDate=" + createdDate + ", interviewDate="
				+ interviewDate + ", interviewTime=" + interviewTime + "]";
	}

}
