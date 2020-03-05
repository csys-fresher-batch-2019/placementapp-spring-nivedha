package com.chainsys.trainingplacementapp.domain;

public class Grade {
	
	private int minMarks;
	private int maxMarks;
	private String status;
	
	public int getMinMarks() {
		return minMarks;
	}
	public void setMinMarks(int minMarks) {
		this.minMarks = minMarks;
	}
	public int getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Grade [minMarks=" + minMarks + ", maxMarks=" + maxMarks + ", status=" + status + "]";
	}
}
