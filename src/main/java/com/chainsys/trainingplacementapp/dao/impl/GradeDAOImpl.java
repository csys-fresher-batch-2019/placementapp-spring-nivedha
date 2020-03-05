package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.trainingplacementapp.dao.GradeDAO;
import com.chainsys.trainingplacementapp.domain.Grade;
import com.chainsys.trainingplacementapp.util.DbConnection;
import com.chainsys.trainingplacementapp.util.Logger;

public class GradeDAOImpl implements GradeDAO {
	private static final Logger log = Logger.getInstance();

	@Override
	public void updateStatus() {
		String sql = "update intervieww set inter_status=(select g.status from grade g where marks between g.min_marks and g.max_marks)";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			int row = pst.executeUpdate();
		} catch (Exception e) {
			log.error(e);
		}
	}

	@Override
	public List<Grade> viewGrade() {
		List<Grade> list = new ArrayList<Grade>();
		String sql = "select * from grade";
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Grade g = new Grade();
					g.setMinMarks(rs.getInt("min_marks"));
					g.setMaxMarks(rs.getInt("max_marks"));
					g.setStatus(rs.getString("status"));
					list.add(g);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}

	@Override
	public void updateGrade(int minMarks, int maxMarks, String status) {
		String sql = "update grade set min_marks=?,max_marks=? where status=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, minMarks);
			pst.setInt(2, maxMarks);
			pst.setString(3, status);
			int row = pst.executeUpdate();
		} catch (Exception e) {
			log.error(e);
		}
	}

}
