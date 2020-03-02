package com.chainsys.trainingproject.dao;

import java.util.List;

import com.chainsys.trainingproject.model.Trainer;
import com.chainsys.util.DbException;

public interface TrainerDAO {

	public void addTrainerDetails(Trainer t) throws DbException;

	List<Trainer> listTrainerDetails() throws DbException;
}
