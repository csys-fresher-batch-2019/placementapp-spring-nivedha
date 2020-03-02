package com.chainsys.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.trainingproject.logger.Logger;
import com.chainsys.trainingproject.model.JoinCompanySchedule;
import com.chainsys.trainingproject.model.JoinUserCompany;
import com.chainsys.trainingproject.model.JoinUserCourse;
import com.chainsys.util.DbConnection;
import com.chainsys.util.DbException;

public class JoinDAOImpl {
	private static final Logger log = Logger.getInstance();

	public List<JoinUserCourse> getUserCourseDetails(JoinUserCourse j) throws DbException {
		List<JoinUserCourse> list = new ArrayList<JoinUserCourse>();
		String sql = "select uc.user_id,c.course_id,c.course_name,c.course_fees,c.course_duration,uc.start_date,uc.completion_date,uc.total_amount from course c,usercourse uc where c.course_id=uc.course_id and uc.user_id=?";
		log.getInput("");
		log.getInput("***Display All UserCourse Details***");
		log.getInput("");
		log.getInput(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setInt(1, j.getUserId());
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					JoinUserCourse c = new JoinUserCourse();
					c.setUserId(rs.getInt("user_id"));
					c.setCourseId(rs.getInt("course_id"));
					c.setCourseName(rs.getString("course_name"));
					c.setCourseFees(rs.getInt("course_fees"));
					c.setCourseDuration(rs.getInt("course_duration"));
					Date d = rs.getDate("start_date");
					if (d != null) {
						LocalDate ld = d.toLocalDate();
						c.setStartDate(ld);
					}
					Date da = rs.getDate("completion_date");
					if (da != null) {
						LocalDate ldd = da.toLocalDate();
						c.setCompletionDate(ldd);
					}
					c.setTotalAmount(rs.getInt("total_amount"));
					list.add(c);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}

	public List<JoinUserCompany> getUserCompanyDetails(JoinUserCompany j) throws DbException {
		List<JoinUserCompany> list = new ArrayList<JoinUserCompany>();
		String sql = "select r.user_id,r.user_name,r.qualification,r.mail_id,r.mobile_no,r.gender,c.client_id,c.company_name,c.company_type,c.company_address,c.ph_no,c.contact_person,c.email_id,i.inter_status,i.marks from registration r,clientcmpy c,intervieww i where i.client_id = c.client_id and r.user_id=i.user_id and i.inter_status=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, j.getInterStatus());
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					JoinUserCompany jc = new JoinUserCompany();
					jc.setUserId(rs.getInt("user_id"));
					jc.setUserName(rs.getString("user_name"));
					jc.setQualification(rs.getString("qualification"));
					jc.setMailId(rs.getString("mail_id"));
					jc.setMobileNo(rs.getLong("mobile_no"));
					jc.setGender(rs.getString("gender"));
					jc.setClientId(rs.getInt("client_id"));
					jc.setCompanyName(rs.getString("company_name"));
					jc.setCompanyType(rs.getString("company_type"));
					jc.setCompanyAddress(rs.getString("company_address"));
					jc.setPhoneNo(rs.getLong("ph_no"));
					jc.setContactPerson(rs.getString("contact_person"));
					jc.setEmailId(rs.getString("email_id"));
					jc.setInterStatus(rs.getString("inter_status"));
					jc.setMarks(rs.getInt("marks"));
					list.add(jc);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}

	public List<JoinUserCompany> getUserCompanyDetailsByMarks(JoinUserCompany j) throws DbException {
		List<JoinUserCompany> list = new ArrayList<JoinUserCompany>();
		String sql = "select r.user_id,r.user_name,r.qualification,r.mail_id,r.mobile_no,r.gender,c.client_id,c.company_name,c.company_type,c.company_address,c.ph_no,c.contact_person,c.email_id,i.inter_status,i.marks from registration r,clientcmpy c,intervieww i where i.client_id = c.client_id and r.user_id=i.user_id and i.marks=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, j.getMarks());
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					JoinUserCompany jc = new JoinUserCompany();
					jc.setUserId(rs.getInt("user_id"));
					jc.setUserName(rs.getString("user_name"));
					jc.setQualification(rs.getString("qualification"));
					jc.setMailId(rs.getString("mail_id"));
					jc.setMobileNo(rs.getLong("mobile_no"));
					jc.setGender(rs.getString("gender"));
					jc.setClientId(rs.getInt("client_id"));
					jc.setCompanyName(rs.getString("company_name"));
					jc.setCompanyType(rs.getString("company_type"));
					jc.setCompanyAddress(rs.getString("company_address"));
					jc.setPhoneNo(rs.getLong("ph_no"));
					jc.setContactPerson(rs.getString("contact_person"));
					jc.setEmailId(rs.getString("email_id"));
					jc.setInterStatus(rs.getString("inter_status"));
					jc.setMarks(rs.getInt("marks"));
					list.add(jc);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}

	public List<JoinCompanySchedule> getCompanySchedule(String interviewDate) throws DbException {
		List<JoinCompanySchedule> list = new ArrayList<JoinCompanySchedule>();
		String sql = "select cc.company_name,cc.company_type,cc.company_address,cc.ph_no,cc.contact_person,cc.email_id,s.job_title,s.job_requirement,s.interview_date,s.interview_time from clientcmpy cc,schedule s where \r\n"
				+ "cc.client_id=s.client_id and s.interview_date=?";
		log.getInput("***Display All Users Selected Details***");
		log.getInput(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setDate(1, Date.valueOf(interviewDate));
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					JoinCompanySchedule jc = new JoinCompanySchedule();
					jc.setCompanyName(rs.getString("company_name"));
					jc.setCompanyType(rs.getString("company_type"));
					jc.setCompanyAddress(rs.getString("company_address"));
					jc.setPhoneNo(rs.getLong("ph_no"));
					jc.setContactPerson(rs.getString("contact_person"));
					jc.setEmailId(rs.getString("email_id"));
					jc.setJobTitle(rs.getString("job_title"));
					jc.setJobRequirement(rs.getString("job_requirement"));
					Date id = rs.getDate("interview_date");
					if (id != null) {
						LocalDate l = id.toLocalDate();
						jc.setInterviewDate(l);
					}
					jc.setInterviewTime(LocalTime.parse(rs.getString("interview_time")));
					list.add(jc);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}

	public List<JoinCompanySchedule> searchByJob(JoinCompanySchedule in) throws DbException {

		List<JoinCompanySchedule> list = new ArrayList<JoinCompanySchedule>();
		String sql = "select c.company_name,c.company_type,c.company_address,c.ph_no,c.contact_person,c.email_id,s.job_title,s.job_requirement,s.interview_date,s.interview_time from schedule s,clientcmpy c where s.client_id=c.client_id and s.job_requirement like ? or s.job_title=?";
		log.getInput(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, "%" + in.getJobRequirement() + "%");
			pst.setString(2, in.getJobTitle());
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					JoinCompanySchedule i = new JoinCompanySchedule();
					i.setCompanyName(rs.getString("company_name"));
					i.setCompanyType(rs.getString("company_type"));
					i.setCompanyAddress(rs.getString("company_address"));
					i.setPhoneNo(rs.getLong("ph_no"));
					i.setContactPerson(rs.getString("contact_person"));
					i.setEmailId(rs.getString("email_id"));
					i.setJobTitle(rs.getString("job_title"));
					i.setJobRequirement(rs.getString("job_requirement"));
					Date id = rs.getDate("interview_date");
					if (id != null) {
						LocalDate l = id.toLocalDate();
						i.setInterviewDate(l);
					}
					i.setInterviewTime(LocalTime.parse(rs.getString("interview_time")));
					list.add(i);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}

	public List<JoinUserCompany> getStatusByUserId(JoinUserCompany j) throws DbException {
		List<JoinUserCompany> list = new ArrayList<JoinUserCompany>();
		String sql = "select r.user_id,r.user_name,c.client_id,c.company_name,i.inter_status,i.marks from registration r,clientcmpy c,intervieww i where i.client_id = c.client_id and r.user_id=i.user_id and i.user_id=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, j.getUserId());
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					JoinUserCompany jc = new JoinUserCompany();
					jc.setUserId(rs.getInt("user_id"));
					jc.setUserName(rs.getString("user_name"));
					jc.setClientId(rs.getInt("client_id"));
					jc.setCompanyName(rs.getString("company_name"));
					jc.setMarks(rs.getInt("marks"));
					jc.setInterStatus(rs.getString("inter_status"));
					list.add(jc);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}
}