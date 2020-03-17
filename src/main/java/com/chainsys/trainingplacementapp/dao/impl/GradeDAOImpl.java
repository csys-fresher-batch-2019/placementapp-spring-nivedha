package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.trainingplacementapp.dao.GradeDAO;
import com.chainsys.trainingplacementapp.domain.Grade;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;
@Repository
public class GradeDAOImpl implements GradeDAO {
	private static final Logger logger = LoggerFactory.getLogger(GradeDAOImpl.class);

	@Override
	public void updateStatusByMarks() throws DbException {
		String sql = "update intervieww set inter_status=(select g.status from grade g where marks between g.min_marks and g.max_marks)";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
			throw new DbException("Unable to Update Interview Status", e);
		}
	}

	@Override
	public List<Grade> findAll() throws DbException {
		List<Grade> list = new ArrayList<Grade>();
		String sql = "select min_marks,max_marks,status from grade";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Grade grade = new Grade();
					grade.setMinMarks(rs.getInt("min_marks"));
					grade.setMaxMarks(rs.getInt("max_marks"));
					grade.setStatus(rs.getString("status"));
					list.add(grade);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Grade Details", e);
		}
		return list;
	}

	@Override
	public void updateMarksByStatus(int minMarks, int maxMarks, String status) throws DbException {
		String sql = "update grade set min_marks=?,max_marks=? where status=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, minMarks);
			pst.setInt(2, maxMarks);
			pst.setString(3, status);
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
			throw new DbException("Unable to Update Marks", e);
		}
	}

}
