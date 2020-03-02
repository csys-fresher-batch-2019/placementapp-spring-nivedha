package com.chainsys.trainingproject.model;

public class ClientCompany {
	private  int clientId;
	private  String companyName;
	private  String companyType;
	private  String companyAddress;
	private  long phoneNo;
	private  String contactPerson;
	private  String emailId; 
	
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

	public String toString() {
	
	StringBuffer content=new StringBuffer();
	content.append("ClientId = ").append(clientId+" ");
	content.append("CompanyName = ").append(companyName+" ");
	content.append("CompanyType = ").append(companyType+" ");
	content.append("CompanyAddress = ").append(companyAddress+" ");
	content.append("PhoneNo = ").append(phoneNo+" ");
	content.append("ContactPerson = ").append(contactPerson+" ");
	content.append("EmailId = ").append(emailId+" ");
	return content.toString();
	
    }
	
}
