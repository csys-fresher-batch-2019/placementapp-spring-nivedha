package com.chainsys.trainingplacementapp.exception;

public class DbException extends Exception {

	private static final long serialVersionUID = 1L;

	public DbException(String msg, Throwable e) {
		super(msg, e);
	}
}
