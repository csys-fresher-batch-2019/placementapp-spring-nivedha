package com.chainsys.trainingproject.model;

public class JoinUserCompany {

	private int userId;
	private String userName;
	private String qualification;
	private String mailId;
	private long mobileNo;
	private String userCity;
	private String gender;
	private  int clientId;
	private  String companyName;
	private  String companyType;
	private  String companyAddress;
	private  long phoneNo;
	private  String contactPerson;
	private  String emailId;
	private int marks;
	private String interStatus;
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
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
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
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getInterStatus() {
		return interStatus;
	}
	public void setInterStatus(String interStatus) {
		this.interStatus = interStatus;
	}
	@Override
	public String toString() {
		return " *************************************\n USER DETAILS: \n userId: " + userId + "\n"
				+ " userName: " + userName + "\n qualification: " + qualification
				+ "\n mailId: " + mailId + "\n mobileNo: " + mobileNo + "\n userCity: " + userCity + "\n gender: " + gender
				+ "\n\n CLIENT DETAILS:\n clientId: " + clientId + "\n companyName: " + companyName + "\n companyType: " + companyType
				+ "\n companyAddress: " + companyAddress + "\n phoneNo: " + phoneNo + "\n contactPerson: " + contactPerson
				+ "\n emailId: " + emailId + "\n marks: " + marks + "\n interStatus: " + interStatus + "\n *************************************\n";
	}
	
	
}
