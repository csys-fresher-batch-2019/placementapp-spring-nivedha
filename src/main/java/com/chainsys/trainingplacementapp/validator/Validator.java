package com.chainsys.trainingplacementapp.validator;

import org.springframework.stereotype.Component;

import com.chainsys.trainingplacementapp.domain.AdminLogin;
import com.chainsys.trainingplacementapp.domain.ClientCompany;
import com.chainsys.trainingplacementapp.domain.InterviewSchedule;
import com.chainsys.trainingplacementapp.domain.Registration;
import com.chainsys.trainingplacementapp.domain.Trainer;
import com.chainsys.trainingplacementapp.exception.ValidatorException;

@Component
public class Validator {

	public static void validateRegistration(Registration r) throws ValidatorException {
		if (r.getUserName() == null || "".equals(r.getUserName().trim())) {
			throw new ValidatorException("Name cannot be blank/empty");
		}
		if (r.getMailId() == null || "".equals(r.getMailId().trim())) {
			throw new ValidatorException("Mail-id cannot be blank/empty");
		}
		if (r.getUserPassword() == null || "".equals(r.getUserPassword().trim())) {
			throw new ValidatorException("Password cannot be blank/empty");
		}
		if (r.getGender() == null || "".equals(r.getGender().trim())) {
			throw new ValidatorException("Gender cannot be blank/empty");
		}
		if (r.getMobileNo() <= 0 || Long.toString(r.getMobileNo()).length() < 10
				|| Long.toString(r.getMobileNo()).length() > 10) {
			throw new ValidatorException("Invalid Mobile Number");
		}
		if (r.getQualification() == null || "".equals(r.getQualification().trim())) {
			throw new ValidatorException("Qualification cannot be blank/empty");
		}
		if (r.getUserCity() == null || "".equals(r.getUserCity().trim())) {
			throw new ValidatorException("City cannot be blank/empty");
		}
	}

	public static void validateLogin(String emailId, String password) throws ValidatorException {
		if (emailId == null || "".equals(emailId.trim())) {
			throw new ValidatorException("Mail-id cannot be blank/empty");
		}
		if (password == null || "".equals(password.trim())) {
			throw new ValidatorException("Password cannot be blank/empty");
		}
	}

	public static void validateAdminLogin(AdminLogin a) throws ValidatorException {
		if (a.getMailId() == null || "".equals(a.getMailId().trim())) {
			throw new ValidatorException("Mail-id cannot be blank/empty");
		}
		if (a.getPassword() == null || "".equals(a.getPassword().trim())) {
			throw new ValidatorException("Password cannot be blank/empty");
		}
	}
	public void validateTrainer(Trainer t) throws ValidatorException {
		if (t.getTrainerName() == null || "".equals(t.getTrainerName().trim())) {
			throw new ValidatorException("Name cannot be blank/empty");
		}
		if (t.getTrainerQualification() == null || "".equals(t.getTrainerQualification().trim())) {
			throw new ValidatorException("Qualification cannot be blank/empty");
		}
		if (t.getTrainerSpecialist() == null || "".equals(t.getTrainerSpecialist().trim())) {
			throw new ValidatorException("Trainer Specialist cannot be blank/empty");
		}
		if (t.getTrainerExperience() <= 0) {
			throw new ValidatorException("Trainer Experience cannot be blank/empty/negative");
		}
		if (t.getEmailId() == null || "".equals(t.getEmailId().trim())) {
			throw new ValidatorException("Email Id cannot be blank/empty");
		}
		if (t.getContactNumber() <= 0 || Long.toString(t.getContactNumber()).length() < 10
				|| Long.toString(t.getContactNumber()).length() > 10) {
			throw new ValidatorException("Invalid Mobile Number");
		}
	
	}
	
	public void validateClientCompany(ClientCompany c) throws ValidatorException {
		if (c.getCompanyName() == null || "".equals(c.getCompanyName().trim())) {
			throw new ValidatorException("CompanyName cannot be blank/empty");
		}
		if (c.getCompanyType() == null || "".equals(c.getCompanyType().trim())) {
			throw new ValidatorException("CompanyType cannot be blank/empty");
		}
		if (c.getCompanyAddress() == null || "".equals(c.getCompanyAddress().trim())) {
			throw new ValidatorException("CompanyAddress cannot be blank/empty");
		}		
		if (c.getPhoneNo() <= 0 || Long.toString(c.getPhoneNo()).length() < 10
				|| Long.toString(c.getPhoneNo()).length() > 10) {
			throw new ValidatorException("Invalid Mobile Number");
		}
		if (c.getContactPerson() == null || "".equals(c.getContactPerson().trim())) {
			throw new ValidatorException("ContactPerson cannot be blank/empty");
		}
		if (c.getEmailId() == null || "".equals(c.getEmailId().trim())) {
			throw new ValidatorException("Email Id cannot be blank/empty");
		}
	
	}
	
	public void validateInterviewSchedule(InterviewSchedule i) throws ValidatorException {
		if (i.getClientId() == 0) {
			throw new ValidatorException("Client Id cannot be blank/empty");
		}
		if (i.getJobTitle() == null || "".equals(i.getJobTitle().trim())) {
			throw new ValidatorException("JobTitle cannot be blank/empty");
		}
		if (i.getJobRequirement() == null || "".equals(i.getJobRequirement().trim())) {
			throw new ValidatorException("JobRequirement cannot be blank/empty");
		}		
		if (i.getInterviewTime() == null) {
			throw new ValidatorException("InterviewTime cannot be blank/empty");
		}
	
	}
}
