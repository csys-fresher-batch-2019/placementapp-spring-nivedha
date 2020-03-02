package com.chainsys.trainingproject.dao;

import java.util.List;

import com.chainsys.trainingproject.model.ClientCompany;
import com.chainsys.trainingproject.model.InterviewSchedule;
import com.chainsys.util.DbException;

public interface InterviewScheduleDAO {

	void addSchedule(InterviewSchedule list) throws DbException;

	List<InterviewSchedule> allInterviewSchedules() throws DbException;

	void deleteSchedule(int interviewId) throws DbException;

	List<ClientCompany> getCompanyDetails(String jobTitle) throws DbException;

}
