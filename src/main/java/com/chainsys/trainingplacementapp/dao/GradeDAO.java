package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.Grade;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface GradeDAO {

	void updateStatusByMarks() throws DbException;

	List<Grade> findAll() throws DbException;

	void updateMarksByStatus(int minMarks, int maxMarks, String status) throws DbException;
}
