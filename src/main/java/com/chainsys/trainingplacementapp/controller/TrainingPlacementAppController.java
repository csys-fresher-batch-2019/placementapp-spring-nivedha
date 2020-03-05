package com.chainsys.trainingplacementapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.trainingplacementapp.dao.CourseDAO;
import com.chainsys.trainingplacementapp.dao.RegistrationDAO;
import com.chainsys.trainingplacementapp.domain.Course;
import com.chainsys.trainingplacementapp.domain.Registration;
import com.chainsys.trainingplacementapp.dto.Messagedto;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.factory.DAOFactory;

@RestController
@RequestMapping("api")
public class TrainingPlacementAppController {
	
	CourseDAO cdao = DAOFactory.getCourseDAO();
	RegistrationDAO rdao=DAOFactory.getRegistrationDAO();
	
	@GetMapping("/allCourseDetails")
	public List<Course> allCourseDetails(@RequestParam("courseName") String courseName) throws DbException{
		List<Course> c = cdao.allCourseDetails(courseName);
		return c;
	}
	
	@GetMapping("/Register")
	public Messagedto Register(@RequestParam("userName")String userName,@RequestParam("password")String password,@RequestParam("city")String city,@RequestParam("mobileNo")long mobileNo,@RequestParam("email")String email,@RequestParam("qualification")String qualification,@RequestParam("gender")String gender) throws DbException {
		Messagedto msg = new Messagedto();
		Registration reg1 = new Registration();
		reg1.setUserName(userName);
		reg1.setUserPassword(password);
		reg1.setUserCity(city);
		reg1.setMobileNo(mobileNo);
		reg1.setMailId(email);
		reg1.setQualification(qualification);
		reg1.setGender(gender);
		int v = rdao.addUserDetails(reg1);
		 if(v == 1) {
			 msg.setInfoMessage("Registered Successfully!!");
		 }
		 else
		 {
			 msg.setErrorMessage("Registration Failed");
		 }

		return msg;
		
}
}
