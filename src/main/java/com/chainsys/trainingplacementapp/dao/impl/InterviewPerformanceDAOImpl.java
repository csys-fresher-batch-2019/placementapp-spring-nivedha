package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.trainingplacementapp.dao.InterviewPerformanceDAO;
import com.chainsys.trainingplacementapp.domain.InterviewPerformance;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;

public class InterviewPerformanceDAOImpl implements InterviewPerformanceDAO {

	private static final Logger logger = LoggerFactory.getLogger(InterviewPerformanceDAOImpl.class);

	public void save(int clientId, int userId) throws DbException {
		String sql = "insert into intervieww(sl_no,client_id,user_id)values(sl_no_sqn.nextval,?,?)";
		logger.info("");
		logger.info("***Add Interview Performance Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, clientId);
			pst.setInt(2, userId);
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (Exception e) {
			throw new DbException("Unable to Add Interview Performance Details", e);
		}
	}

	public List<InterviewPerformance> findAll() throws DbException {

		List<InterviewPerformance> list = new ArrayList<InterviewPerformance>();
		String sql = "select sl_no,client_id,user_id,marks,inter_status from intervieww";
		logger.info("***Display Interview Performance Details***");
		logger.info("");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					InterviewPerformance ip = new InterviewPerformance();
					ip.setPerformId(rs.getInt("sl_no"));
					ip.setClientId(rs.getInt("client_id"));
					ip.setUserId(rs.getInt("user_id"));
					ip.setMarks(rs.getInt("marks"));
					ip.setInterStatus(rs.getString("inter_status"));
					list.add(ip);
				}
			}
		} catch (Exception e) {
			throw new DbException("Unable to Find Interview Performance Details", e);
		}
		return list;
	}

	@Override
	public void updateInterviewMarksById(int marks, int performId) throws DbException {
		String sql = "update intervieww set marks=? where sl_no=?";
		logger.info("");
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, marks);
			pst.setInt(2, performId);
			int row = pst.executeUpdate();
		} catch (Exception e) {
			throw new DbException("Unable to Update Interview Marks", e);
		}
	}
}
