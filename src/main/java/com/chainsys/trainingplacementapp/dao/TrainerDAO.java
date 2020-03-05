package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.Trainer;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface TrainerDAO {

	public void addTrainerDetails(Trainer t) throws DbException;

	List<Trainer> listTrainerDetails() throws DbException;
}
