package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.trainingplacementapp.dao.InterviewPerformanceDAO;
import com.chainsys.trainingplacementapp.domain.InterviewPerformance;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;
import com.chainsys.trainingplacementapp.util.Logger;

public class InterviewPerformanceDAOImpl implements InterviewPerformanceDAO {

	private static final Logger log = Logger.getInstance();

	public void addPerformanceDetails(int clientId, int userId) throws DbException {
		String sql = "insert into intervieww(sl_no,client_id,user_id)values(sl_no_sqn.nextval,?,?)";
		log.getInput("");
		log.getInput("***Add Interview Performance Details***");
		log.getInput(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, clientId);
			pst.setInt(2, userId);
			int row = pst.executeUpdate();
			log.getInput(row);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public List<InterviewPerformance> viewPerformanceStatus() throws DbException {

		List<InterviewPerformance> list = new ArrayList<InterviewPerformance>();
		String sql = "select sl_no,client_id,user_id,marks,inter_status from intervieww";
		log.getInput("***Display Interview Performance Details***");
		log.getInput("");
		log.getInput(sql);
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
			log.error(e);
		}
		return list;
	}

	@Override
	public void updateInterviewMarks(int marks, int performId) throws DbException {
		String sql = "update intervieww set marks=? where sl_no=?";
		log.getInput("");
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, marks);
			pst.setInt(2, performId);
			int row = pst.executeUpdate();
		} catch (Exception e) {
			log.error(e);
		}
	}
}
