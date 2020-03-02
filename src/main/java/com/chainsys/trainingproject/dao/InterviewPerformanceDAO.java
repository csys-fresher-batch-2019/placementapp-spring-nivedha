package com.chainsys.trainingproject.dao;

import java.util.List;

import com.chainsys.trainingproject.model.InterviewPerformance;
import com.chainsys.util.DbException;

public interface InterviewPerformanceDAO {

	void addPerformanceDetails(int clientId, int userId) throws  DbException;

	void updateInterviewMarks(int marks, int performId) throws DbException;

	List<InterviewPerformance> viewPerformanceStatus() throws DbException;

}
