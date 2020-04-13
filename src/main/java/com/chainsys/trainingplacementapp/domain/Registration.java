package com.chainsys.trainingplacementapp.domain;

public class Registration {
	private int userId;
	private String userName;
	private String mailId;
	private String userPassword;
	private String userCity;
	private long mobileNo;
	private String qualification;
	private String gender;
	private String profile;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMailId() {
		return mailId;
	}

	public String setMailId(String mailId) {
		return this.mailId = mailId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public long setMobileNo(long mobileNo) {
		return this.mobileNo = mobileNo;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Registration [userId=" + userId + ", userName=" + userName + ", mailId=" + mailId + ", userPassword="
				+ userPassword + ", userCity=" + userCity + ", mobileNo=" + mobileNo + ", qualification="
				+ qualification + ", gender=" + gender + ",profile=" + profile +"]";
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}
