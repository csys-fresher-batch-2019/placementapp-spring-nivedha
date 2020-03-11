package com.chainsys.trainingplacementapp.exception;

public class ServiceException extends Exception {
	
	public ServiceException(Throwable e) {
		super(e);
	}
	public ServiceException(String msg, Throwable e) {
		super(msg, e);
	}
}
