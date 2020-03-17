package com.chainsys.trainingplacementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainingplacementapp.dao.InterviewScheduleDAO;
import com.chainsys.trainingplacementapp.domain.InterviewSchedule;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ServiceException;

@Service
public class InterviewScheduleService {
	@Autowired
	InterviewScheduleDAO interviewScheduleDAO;

	public List<InterviewSchedule> findScheduleByInterviewDate() throws ServiceException {
		List<InterviewSchedule> list = null;
		try {
			list = interviewScheduleDAO.findAllByInterviewDate();
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;

	}
}
