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

import com.chainsys.trainingplacementapp.dao.TrainerDAO;
import com.chainsys.trainingplacementapp.domain.Trainer;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;
@Repository
public class TrainerDAOImpl implements TrainerDAO {
	private static final Logger logger = LoggerFactory.getLogger(TrainerDAOImpl.class);

	public void save(Trainer trainer) throws DbException {

		String sql = "insert into trainer(trainer_id,trainer_name,trainer_qualfication,trainer_specialist,trainer_experience,email_id,contact_number)values(trainer_id_sqn.nextval,?,?,?,?,?,?)";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, trainer.getTrainerName());
			pst.setString(2, trainer.getTrainerQualification());
			pst.setString(3, trainer.getTrainerSpecialist());
			pst.setInt(4, trainer.getTrainerExperience());
			pst.setString(5, trainer.getEmailId());
			pst.setLong(6, trainer.getContactNumber());
			int row = pst.executeUpdate();
			logger.info("" + row);
			logger.info("***Added Trainer Details successfully***");
		} catch (SQLException e) {
			throw new DbException("Unable to Add Trainer Details", e);
		}
	}

	@Override
	public List<Trainer> findAll() throws DbException {
		List<Trainer> list = new ArrayList<Trainer>();
		String sql = "select trainer_id,trainer_name,trainer_qualfication,trainer_specialist,trainer_experience,email_id,contact_number from trainer";
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Trainer trainer = new Trainer();
					trainer.setTrainerId(rs.getInt("trainer_id"));
					trainer.setTrainerName(rs.getString("trainer_name"));
					trainer.setTrainerQualification(rs.getString("trainer_qualfication"));
					trainer.setTrainerSpecialist(rs.getString("trainer_specialist"));
					trainer.setTrainerExperience(rs.getInt("trainer_experience"));
					trainer.setEmailId(rs.getString("email_id"));
					trainer.setContactNumber(rs.getLong("contact_number"));
					list.add(trainer);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Trainer Details", e);
		}
		return list;
	}
}