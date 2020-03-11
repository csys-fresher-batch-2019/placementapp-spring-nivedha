package com.chainsys.trainingplacementapp.domain;

public class AdminLogin {
	private String mailId;
	private String Password;
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "AdminLogin [mailId=" + mailId + ", Password=" + Password + "]";
	}
	
}
