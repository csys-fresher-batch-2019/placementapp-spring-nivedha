package com.chainsys.trainingplacementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.GradeDAO;
import com.chainsys.trainingplacementapp.domain.Grade;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;

@Service
public class GradeService {

	@Autowired
	GradeDAO gradeDAO;

	public void updateInterviewMarkByStatus(int minMarks, int maxMarks, String status) throws ServiceException {
		try {
			gradeDAO.updateMarksByStatus(minMarks, maxMarks, status);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
	}

	public void updateInterviewStatusByMarks() throws ServiceException {
		try {
			gradeDAO.updateStatusByMarks();
		} catch (DbException e) {
			throw new ServiceException(e);
		}
	}

	public List<Grade> FindGradeDetails() throws ServiceException {
		List<Grade> list = null;
		try {
			list=gradeDAO.findAll();
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;

	}
}
