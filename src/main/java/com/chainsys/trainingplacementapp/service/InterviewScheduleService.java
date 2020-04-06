package com.chainsys.trainingplacementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.InterviewScheduleDAO;
import com.chainsys.trainingplacementapp.domain.InterviewSchedule;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;
import com.chainsys.trainingplacementapp.exception.ValidatorException;
import com.chainsys.trainingplacementapp.validator.Validator;

@Service
public class InterviewScheduleService {
	@Autowired
	InterviewScheduleDAO interviewScheduleDAO;

	@Autowired
	Validator validator;

	public List<InterviewSchedule> findScheduleByInterviewDate() throws ServiceException {
		List<InterviewSchedule> list = null;
		try {
			list = interviewScheduleDAO.findAllByInterviewDate();
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	public void addInterviewScheduleDetails(InterviewSchedule interviewSchedule) throws ServiceException {
		try {
			validator.validateInterviewSchedule(interviewSchedule);
			interviewScheduleDAO.save(interviewSchedule);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
