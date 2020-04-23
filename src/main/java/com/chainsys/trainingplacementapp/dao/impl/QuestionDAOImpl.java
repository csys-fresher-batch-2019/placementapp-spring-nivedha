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

import com.chainsys.trainingplacementapp.dao.QuestionDAO;
import com.chainsys.trainingplacementapp.domain.Question;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;
@Repository
public class QuestionDAOImpl implements QuestionDAO {
	private static final Logger logger = LoggerFactory.getLogger(QuestionDAOImpl.class);

	@Override
	public List<Question> findAll() throws DbException {
		List<Question> list = new ArrayList<Question>();
		String sql = "select * from question";
		logger.info("***Display Questions***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Question question = new Question();
					question.setCategoryId(rs.getInt("category_id"));
					question.setQuestionId(rs.getInt("question_id"));
					question.setQuestion(rs.getString("question"));
					list.add(question);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Question", e);
		}
		return list;
	}

	@Override
	public List<Question> findByCategoryId(int categoryId) throws DbException {
		List<Question> list = new ArrayList<Question>();
		String sql = "select * from question where category_id=?";
		logger.info("***Display Questions***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, categoryId);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Question question = new Question();
					question.setCategoryId(rs.getInt("category_id"));
					question.setQuestionId(rs.getInt("question_id"));
					question.setQuestion(rs.getString("question"));
					list.add(question);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Question", e);
		}
		return list;
	}

}
