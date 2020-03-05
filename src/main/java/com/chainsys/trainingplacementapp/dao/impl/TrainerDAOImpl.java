package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.trainingplacementapp.dao.TrainerDAO;
import com.chainsys.trainingplacementapp.domain.Trainer;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;
import com.chainsys.trainingplacementapp.util.Logger;

public class TrainerDAOImpl implements TrainerDAO {
	private static final Logger log = Logger.getInstance();

	public void addTrainerDetails(Trainer t) throws DbException {

		String sql = "insert into trainer(trainer_id,trainer_name,trainer_qualfication,trainer_specialist,trainer_experience,email_id,contact_number)values(trainer_id_sqn.nextval,?,?,?,?,?,?)";
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, t.getTrainerName());
			pst.setString(2, t.getTrainerQualification());
			pst.setString(3, t.getTrainerSpecialist());
			pst.setInt(4, t.getTrainerExperience());
			pst.setString(5, t.getEmailId());
			pst.setLong(6, t.getContactNumber());
			int row = pst.executeUpdate();
			log.getInput("***Added Trainer Details successfully***");
		} catch (Exception e) {
			log.error(e);
		}
	}

	@Override
	public List<Trainer> listTrainerDetails() throws DbException {
		List<Trainer> list = new ArrayList<Trainer>();
		String sql = "select * from trainer";
		log.getInput(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Trainer tr = new Trainer();
					tr.setTrainerId(rs.getInt("trainer_id"));
					tr.setTrainerName(rs.getString("trainer_name"));
					tr.setTrainerQualification(rs.getString("trainer_qualfication"));
					tr.setTrainerSpecialist(rs.getString("trainer_specialist"));
					tr.setTrainerExperience(rs.getInt("trainer_experience"));
					tr.setEmailId(rs.getString("email_id"));
					tr.setContactNumber(rs.getLong("contact_number"));
					list.add(tr);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}
}