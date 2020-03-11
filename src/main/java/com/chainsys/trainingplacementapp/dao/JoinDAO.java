package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.JoinCompanySchedule;
import com.chainsys.trainingplacementapp.domain.JoinUserCompany;
import com.chainsys.trainingplacementapp.domain.JoinUserCourse;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface JoinDAO {

	public List<JoinUserCourse> findAllByCourseIdAndUserId(JoinUserCourse j) throws DbException;
	
	public List<JoinUserCompany> findUsersByInterviewStatus(JoinUserCompany j) throws DbException;
	
	public List<JoinUserCompany> findUsersByInterviewMarks(JoinUserCompany j) throws DbException;
	
	public List<JoinCompanySchedule> findInterviewScheduleByInterviewDate(String interviewDate) throws DbException;
	
	public List<JoinCompanySchedule> findCompaniesByJobRequirementAndTitle(JoinCompanySchedule in) throws DbException;
	
	public List<JoinUserCompany> findUserStatusByUserId(JoinUserCompany j) throws DbException;
	
}
