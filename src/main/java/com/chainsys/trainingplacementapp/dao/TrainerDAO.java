package com.chainsys.trainingplacementapp.dao;

import java.util.List;

import com.chainsys.trainingplacementapp.domain.Trainer;
import com.chainsys.trainingplacementapp.exception.DbException;

public interface TrainerDAO {

	public void save(Trainer trainer) throws DbException;

	List<Trainer> findAll() throws DbException;
	
	String findTrainerNameById(int trainerId) throws DbException;

}
