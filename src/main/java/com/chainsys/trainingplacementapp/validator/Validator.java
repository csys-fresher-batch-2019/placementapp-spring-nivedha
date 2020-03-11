package com.chainsys.trainingplacementapp.validator;

import org.springframework.stereotype.Component;

import com.chainsys.trainingplacementapp.domain.AdminLogin;
import com.chainsys.trainingplacementapp.domain.Registration;
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
		if (r.getMobileNo() == 0 || Long.toString(r.getMobileNo()).length() < 10
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

	public static void validateLogin(Registration r) throws ValidatorException {
		if (r.getMailId() == null || "".equals(r.getMailId().trim())) {
			throw new ValidatorException("Mail-id cannot be blank/empty");
		}
		if (r.getUserPassword() == null || "".equals(r.getUserPassword().trim())) {
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
}
