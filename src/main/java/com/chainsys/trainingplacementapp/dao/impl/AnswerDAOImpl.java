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

import com.chainsys.trainingplacementapp.dao.AnswerDAO;
import com.chainsys.trainingplacementapp.domain.Answer;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;
@Repository
public class AnswerDAOImpl implements AnswerDAO {
	private static final Logger logger = LoggerFactory.getLogger(AnswerDAOImpl.class);

	@Override
	public List<Answer> findAll() throws DbException {
		List<Answer> list = new ArrayList<Answer>();
		String sql = "select * from answer";
		logger.info("***Display Answers***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Answer answer = new Answer();
					answer.setAnswerId(rs.getInt("answer_id"));
					answer.setQuestionId(rs.getInt("question_id"));
					answer.setAnswer(rs.getString("answer"));
					list.add(answer);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Answer", e);
		}
		return list;
	}

	@Override
	public List<Answer> findByQuestionId(int questionId) throws DbException {
		List<Answer> list = new ArrayList<Answer>();
		String sql = "select * from answer where question_id=?";
		logger.info("***Display Answers***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, questionId);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Answer answer = new Answer();
					answer.setAnswerId(rs.getInt("answer_id"));
					answer.setQuestionId(rs.getInt("question_id"));
					answer.setAnswer(rs.getString("answer"));
					list.add(answer);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Answer", e);
		}
		return list;
	}

	@Override
	public List<Answer> findAnswerByQuestionId(int questionId) throws DbException {
		List<Answer> list = new ArrayList<Answer>();
		String sql = "select q.question_id,a.answer_id,q.question,a.answer from question q,answer a where q.question_id=a.question_id and q.question_id=?";
		logger.info("***Display Answers***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, questionId);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Answer answer = new Answer();
					answer.setAnswerId(rs.getInt("answer_id"));
					answer.setQuestionId(rs.getInt("question_id"));
					answer.setQuestion(rs.getString("question"));
					answer.setAnswer(rs.getString("answer"));
					list.add(answer);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Answer", e);
		}
		return list;
	}

}
