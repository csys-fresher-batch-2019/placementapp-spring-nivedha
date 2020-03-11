package com.chainsys.trainingplacementapp.domain;

public class AdminLogin {
	private String mailId;
	private String password;

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String adminPassword) {
		password = adminPassword;
	}

	@Override
	public String toString() {
		return "AdminLogin [mailId=" + mailId + ", password=" + password + "]";
	}

}
