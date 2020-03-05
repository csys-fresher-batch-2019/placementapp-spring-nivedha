package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.InterviewPerformance;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface InterviewPerformanceDAO {

	void addPerformanceDetails(int clientId, int userId) throws  DbException;

	void updateInterviewMarks(int marks, int performId) throws DbException;

	List<InterviewPerformance> viewPerformanceStatus() throws DbException;

}
