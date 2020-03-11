package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.CompanyScheduleDTO;
import com.chainsys.trainingplacementapp.domain.UserCompanyDTO;
import com.chainsys.trainingplacementapp.domain.UserCourseDTO;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface JoinDAO {

	public List<UserCourseDTO> findAllByCourseIdAndUserId(UserCourseDTO userCourseDTO) throws DbException;

	public List<UserCompanyDTO> findUsersByInterviewStatus(UserCompanyDTO userCompanyDTO) throws DbException;

	public List<UserCompanyDTO> findUsersByInterviewMarks(UserCompanyDTO userCompanyDTO) throws DbException;

	public List<CompanyScheduleDTO> findInterviewScheduleByInterviewDate(String interviewDate) throws DbException;

	public List<CompanyScheduleDTO> findCompaniesByJobRequirementAndTitle(CompanyScheduleDTO companyScheduleDTO)
			throws DbException;

	public List<UserCompanyDTO> findUserStatusByUserId(UserCompanyDTO userCompanyDTO) throws DbException;

}
