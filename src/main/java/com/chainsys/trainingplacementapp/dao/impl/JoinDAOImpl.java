package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.trainingplacementapp.dao.JoinDAO;
import com.chainsys.trainingplacementapp.domain.CompanyScheduleDTO;
import com.chainsys.trainingplacementapp.domain.UserCompanyDTO;
import com.chainsys.trainingplacementapp.domain.UserCourseDTO;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;
@Repository
public class JoinDAOImpl implements JoinDAO {
	private static final Logger logger = LoggerFactory.getLogger(JoinDAOImpl.class);

	public List<UserCourseDTO> findAllByCourseIdAndUserId(UserCourseDTO usercourseDTO) throws DbException {
		List<UserCourseDTO> list = new ArrayList<UserCourseDTO>();
		String sql = "select uc.user_id,c.course_id,c.course_name,c.course_fees,c.course_duration,uc.start_date,uc.completion_date,uc.total_amount from course c,usercourse uc where c.course_id=uc.course_id and uc.user_id=?";
		logger.info("***Display All UserCourse Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setInt(1, usercourseDTO.getUserId());
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					UserCourseDTO userCourseDTO = new UserCourseDTO();
					userCourseDTO.setUserId(rs.getInt("user_id"));
					userCourseDTO.setCourseId(rs.getInt("course_id"));
					userCourseDTO.setCourseName(rs.getString("course_name"));
					userCourseDTO.setCourseFees(rs.getInt("course_fees"));
					userCourseDTO.setCourseDuration(rs.getInt("course_duration"));
					Date d = rs.getDate("start_date");
					if (d != null) {
						LocalDate ld = d.toLocalDate();
						userCourseDTO.setStartDate(ld);
					}
					Date da = rs.getDate("completion_date");
					if (da != null) {
						LocalDate ldd = da.toLocalDate();
						userCourseDTO.setCompletionDate(ldd);
					}
					userCourseDTO.setTotalAmount(rs.getInt("total_amount"));
					list.add(userCourseDTO);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find User Course Details", e);
		}
		return list;
	}

	public List<UserCompanyDTO> findUsersByInterviewStatus(UserCompanyDTO userCompanyDTO) throws DbException {
		List<UserCompanyDTO> list = new ArrayList<UserCompanyDTO>();
		String sql = "select r.user_id,r.user_name,r.qualification,r.mail_id,r.mobile_no,r.gender,c.client_id,c.company_name,c.company_type,c.company_address,c.ph_no,c.contact_person,c.email_id,i.inter_status,i.marks from registration r,clientcmpy c,intervieww i where i.client_id = c.client_id and r.user_id=i.user_id and i.inter_status=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, userCompanyDTO.getInterviewStatus());
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					UserCompanyDTO userCompany = new UserCompanyDTO();
					userCompany.setUserId(rs.getInt("user_id"));
					userCompany.setUserName(rs.getString("user_name"));
					userCompany.setQualification(rs.getString("qualification"));
					userCompany.setMailId(rs.getString("mail_id"));
					userCompany.setMobileNo(rs.getLong("mobile_no"));
					userCompany.setGender(rs.getString("gender"));
					userCompany.setClientId(rs.getInt("client_id"));
					userCompany.setCompanyName(rs.getString("company_name"));
					userCompany.setCompanyType(rs.getString("company_type"));
					userCompany.setCompanyAddress(rs.getString("company_address"));
					userCompany.setPhoneNo(rs.getLong("ph_no"));
					userCompany.setContactPerson(rs.getString("contact_person"));
					userCompany.setEmailId(rs.getString("email_id"));
					userCompany.setInterviewStatus(rs.getString("inter_status"));
					userCompany.setMarks(rs.getInt("marks"));
					list.add(userCompany);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find User Company Details", e);
		}
		return list;
	}

	public List<UserCompanyDTO> findUsersByInterviewMarks(UserCompanyDTO userCompanyDTO) throws DbException {
		List<UserCompanyDTO> list = new ArrayList<UserCompanyDTO>();
		String sql = "select r.user_id,r.user_name,r.qualification,r.mail_id,r.mobile_no,r.gender,c.client_id,c.company_name,c.company_type,c.company_address,c.ph_no,c.contact_person,c.email_id,i.inter_status,i.marks from registration r,clientcmpy c,intervieww i where i.client_id = c.client_id and r.user_id=i.user_id and i.marks=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userCompanyDTO.getMarks());
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					UserCompanyDTO userCompany = new UserCompanyDTO();
					userCompany.setUserId(rs.getInt("user_id"));
					userCompany.setUserName(rs.getString("user_name"));
					userCompany.setQualification(rs.getString("qualification"));
					userCompany.setMailId(rs.getString("mail_id"));
					userCompany.setMobileNo(rs.getLong("mobile_no"));
					userCompany.setGender(rs.getString("gender"));
					userCompany.setClientId(rs.getInt("client_id"));
					userCompany.setCompanyName(rs.getString("company_name"));
					userCompany.setCompanyType(rs.getString("company_type"));
					userCompany.setCompanyAddress(rs.getString("company_address"));
					userCompany.setPhoneNo(rs.getLong("ph_no"));
					userCompany.setContactPerson(rs.getString("contact_person"));
					userCompany.setEmailId(rs.getString("email_id"));
					userCompany.setInterviewStatus(rs.getString("inter_status"));
					userCompany.setMarks(rs.getInt("marks"));
					list.add(userCompany);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find User Interview Status Details", e);
		}
		return list;
	}

	public List<CompanyScheduleDTO> findInterviewScheduleByInterviewDate(String interviewDate) throws DbException {
		List<CompanyScheduleDTO> list = new ArrayList<CompanyScheduleDTO>();
		String sql = "select cc.company_name,cc.company_type,cc.company_address,cc.ph_no,cc.contact_person,cc.email_id,s.job_title,s.job_requirement,s.interview_date,s.interview_time from clientcmpy cc,schedule s where \r\n"
				+ "cc.client_id=s.client_id and s.interview_date=?";
		logger.info("***Display All Users Selected Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setDate(1, Date.valueOf(interviewDate));
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					CompanyScheduleDTO userCompany = new CompanyScheduleDTO();
					userCompany.setCompanyName(rs.getString("company_name"));
					userCompany.setCompanyType(rs.getString("company_type"));
					userCompany.setCompanyAddress(rs.getString("company_address"));
					userCompany.setPhoneNo(rs.getLong("ph_no"));
					userCompany.setContactPerson(rs.getString("contact_person"));
					userCompany.setEmailId(rs.getString("email_id"));
					userCompany.setJobTitle(rs.getString("job_title"));
					userCompany.setJobRequirement(rs.getString("job_requirement"));
					Date id = rs.getDate("interview_date");
					if (id != null) {
						LocalDate l = id.toLocalDate();
						userCompany.setInterviewDate(l);
					}
					userCompany.setInterviewTime(LocalTime.parse(rs.getString("interview_time")));
					list.add(userCompany);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Company Interview Schedule Details", e);
		}
		return list;
	}

	public List<CompanyScheduleDTO> findCompaniesByJobRequirementAndTitle(CompanyScheduleDTO companyScheduleDTO)
			throws DbException {

		List<CompanyScheduleDTO> list = new ArrayList<CompanyScheduleDTO>();
		String sql = "select c.company_name,c.company_type,c.company_address,c.ph_no,c.contact_person,c.email_id,s.job_title,s.job_requirement,s.interview_date,s.interview_time from schedule s,clientcmpy c where s.client_id=c.client_id and s.job_requirement like ? or s.job_title=?";
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, "%" + companyScheduleDTO.getJobRequirement() + "%");
			pst.setString(2, companyScheduleDTO.getJobTitle());
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					CompanyScheduleDTO companySchedule = new CompanyScheduleDTO();
					companySchedule.setCompanyName(rs.getString("company_name"));
					companySchedule.setCompanyType(rs.getString("company_type"));
					companySchedule.setCompanyAddress(rs.getString("company_address"));
					companySchedule.setPhoneNo(rs.getLong("ph_no"));
					companySchedule.setContactPerson(rs.getString("contact_person"));
					companySchedule.setEmailId(rs.getString("email_id"));
					companySchedule.setJobTitle(rs.getString("job_title"));
					companySchedule.setJobRequirement(rs.getString("job_requirement"));
					Date id = rs.getDate("interview_date");
					if (id != null) {
						LocalDate l = id.toLocalDate();
						companySchedule.setInterviewDate(l);
					}
					companySchedule.setInterviewTime(LocalTime.parse(rs.getString("interview_time")));
					list.add(companySchedule);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Job Requirement Details", e);
		}
		return list;
	}

	public List<UserCompanyDTO> findUserStatusByUserId(UserCompanyDTO userCompanyDTO) throws DbException {
		List<UserCompanyDTO> list = new ArrayList<UserCompanyDTO>();
		String sql = "select r.user_id,r.user_name,c.client_id,c.company_name,i.inter_status,i.marks from registration r,clientcmpy c,intervieww i where i.client_id = c.client_id and r.user_id=i.user_id and i.user_id=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userCompanyDTO.getUserId());
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					UserCompanyDTO userCompany = new UserCompanyDTO();
					userCompany.setUserId(rs.getInt("user_id"));
					userCompany.setUserName(rs.getString("user_name"));
					userCompany.setClientId(rs.getInt("client_id"));
					userCompany.setCompanyName(rs.getString("company_name"));
					userCompany.setMarks(rs.getInt("marks"));
					userCompany.setInterviewStatus(rs.getString("inter_status"));
					list.add(userCompany);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Interview Status Details", e);
		}
		return list;
	}
}