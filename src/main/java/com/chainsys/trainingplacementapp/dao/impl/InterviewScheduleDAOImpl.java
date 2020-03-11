package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.trainingplacementapp.dao.InterviewScheduleDAO;
import com.chainsys.trainingplacementapp.domain.ClientCompany;
import com.chainsys.trainingplacementapp.domain.InterviewSchedule;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ErrorConstant;
import com.chainsys.trainingplacementapp.util.DbConnection;

public class InterviewScheduleDAOImpl implements InterviewScheduleDAO {
	private static final Logger logger = LoggerFactory.getLogger(InterviewScheduleDAOImpl.class);

	public void save(InterviewSchedule schedule) throws DbException {
		String sql = "insert into schedule(interview_id,client_id,job_title,job_requirement,created_date,interview_date,interview_time)"
				+ "values(interview_id_seq.nextval,?,?,?,?,?,?)";
		logger.info("***Add Interview Schedule Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, schedule.getClientId());
			pst.setString(2, schedule.getJobTitle());
			pst.setString(3, schedule.getJobRequirement());
			pst.setDate(4, Date.valueOf(schedule.getCreatedDate()));
			pst.setDate(5, Date.valueOf(schedule.getInterviewDate()));
			pst.setString(6, schedule.getInterviewTime().toString());
			int row = pst.executeUpdate();
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_ADD);
		}
	}

	public List<InterviewSchedule> findAllByInterviewDate() throws DbException {

		List<InterviewSchedule> list = new ArrayList<InterviewSchedule>();
		String sql = "select * from schedule where interview_date>=sysdate";
		logger.info("");
		logger.info("***Display Interview Schedule Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					InterviewSchedule in = new InterviewSchedule();
					in.setInterviewId(rs.getInt("interview_id"));
					in.setClientId(rs.getInt("client_id"));
					in.setJobTitle(rs.getString("job_title"));
					in.setJobRequirement(rs.getString("job_requirement"));
					Date d = rs.getDate("created_date");
					if (d != null) {
						LocalDate ld = d.toLocalDate();
						in.setCreatedDate(ld);
					}
					Date id = rs.getDate("interview_date");
					if (id != null) {
						LocalDate l = id.toLocalDate();
						in.setInterviewDate(l);
					}
					in.setInterviewTime(LocalTime.parse(rs.getString("interview_time")));
					list.add(in);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	public void delete(int interviewId) throws DbException {

		String sql = "delete from schedule where interview_id=?";
		logger.info("");
		logger.info("***Delete Interview Schedule Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, interviewId);
			int row = pst.executeUpdate();
			logger.info(""+row);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_DELETE);
		}
	}

	public List<ClientCompany> findCompanyDetailsByJobRequirement(String jobRequirement) throws DbException {

		List<ClientCompany> list1 = new ArrayList<ClientCompany>();
		String sql = "select client_id,company_name,company_type,company_address,ph_no,contact_person,email_id from clientcmpy where client_id in (select client_id from schedule where job_requirement=?)";
		logger.info("");
		logger.info("***Display the company details based on the job title***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, jobRequirement);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					ClientCompany cc = new ClientCompany();
					cc.setClientId(rs.getInt("client_id"));
					cc.setCompanyName(rs.getString("company_name"));
					cc.setCompanyType(rs.getString("company_type"));
					cc.setCompanyAddress(rs.getString("company_address"));
					cc.setPhoneNo(rs.getLong("ph_no"));
					cc.setContactPerson(rs.getString("contact_person"));
					cc.setEmailId(rs.getString("email_id"));
					list1.add(cc);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return list1;
	}
}
