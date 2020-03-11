package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.ClientCompany;
import com.chainsys.trainingplacementapp.domain.InterviewSchedule;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface InterviewScheduleDAO {

	void save(InterviewSchedule list) throws DbException;

	List<InterviewSchedule> findAllByInterviewDate() throws DbException;

	void delete(int interviewId) throws DbException;

	List<ClientCompany> findCompanyDetailsByJobRequirement(String jobRequirement) throws DbException;

}
