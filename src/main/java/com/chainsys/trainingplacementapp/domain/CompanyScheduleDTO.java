package com.chainsys.trainingplacementapp.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompanyScheduleDTO {

	private String companyName;
	private String companyType;
	private String companyAddress;
	private long phoneNo;
	private String contactPerson;
	private String emailId;
	private String jobTitle;
	private String jobRequirement;
	private LocalDate interviewDate;
	private LocalTime interviewTime;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	@Override
	public String toString() {
		return "JoinCompanySchedule [companyName=" + companyName + ", companyType=" + companyType + ", companyAddress="
				+ companyAddress + ", phoneNo=" + phoneNo + ", contactPerson=" + contactPerson + ", emailId=" + emailId
				+ ", jobTitle=" + jobTitle + ", jobRequirement=" + jobRequirement + ", interviewDate=" + interviewDate
				+ ", interviewTime=" + interviewTime + "]";
	}
}
