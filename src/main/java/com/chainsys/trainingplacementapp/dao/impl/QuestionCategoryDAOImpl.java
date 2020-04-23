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

import com.chainsys.trainingplacementapp.dao.QuestionCategoryDAO;
import com.chainsys.trainingplacementapp.domain.QuestionCategory;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;
@Repository
public class QuestionCategoryDAOImpl implements QuestionCategoryDAO {
	private static final Logger logger = LoggerFactory.getLogger(QuestionCategoryDAOImpl.class);


	@Override
	public List<QuestionCategory> findAll() throws DbException {
		List<QuestionCategory> list = new ArrayList<QuestionCategory>();
		String sql = "select * from questioncategory";
		logger.info("***Display Question Category***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					QuestionCategory qc = new QuestionCategory();
					qc.setCategoryId(rs.getInt("category_id"));
					qc.setCategoryName(rs.getString("category_name"));
					list.add(qc);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Question Category", e);
		}
		return list;
	}

}
