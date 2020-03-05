package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.ClientCompany;
import com.chainsys.trainingplacementapp.domain.InterviewSchedule;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface InterviewScheduleDAO {

	void addSchedule(InterviewSchedule list) throws DbException;

	List<InterviewSchedule> allInterviewSchedules() throws DbException;

	void deleteSchedule(int interviewId) throws DbException;

	List<ClientCompany> getCompanyDetails(String jobTitle) throws DbException;

}
