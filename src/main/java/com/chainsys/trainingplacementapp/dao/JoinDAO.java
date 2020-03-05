package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.JoinCompanySchedule;
import com.chainsys.trainingplacementapp.domain.JoinUserCompany;
import com.chainsys.trainingplacementapp.domain.JoinUserCourse;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface JoinDAO {

	public List<JoinUserCourse> getUserCourseDetails(JoinUserCourse j) throws DbException;
	
	public List<JoinUserCompany> getUserCompanyDetails(JoinUserCompany j) throws DbException;
	
	public List<JoinUserCompany> getUserCompanyDetailsByMarks(JoinUserCompany j) throws DbException;
	
	public List<JoinCompanySchedule> getCompanySchedule(String interviewDate) throws DbException;
	
	public List<JoinCompanySchedule> searchByJob(JoinCompanySchedule in) throws DbException;
	
	public List<JoinUserCompany> getStatusByUserId(JoinUserCompany j) throws DbException;
	
}
