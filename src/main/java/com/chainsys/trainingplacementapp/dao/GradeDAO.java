package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.Grade;

public interface GradeDAO {

	void updateStatus();

	List<Grade> viewGrade();

	void updateGrade(int minMarks, int maxMarks, String status);
}
