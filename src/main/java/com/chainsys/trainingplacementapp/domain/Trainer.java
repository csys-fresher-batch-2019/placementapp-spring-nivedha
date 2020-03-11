package com.chainsys.trainingplacementapp.domain;

public class Trainer {

	private int trainerId;
	private String trainerName;
	private String trainerQualification;
	private String trainerSpecialist;
	private int trainerExperience;
	private String emailId;
	private Long contactNumber;

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerQualification() {
		return trainerQualification;
	}

	public void setTrainerQualification(String trainerQualification) {
		this.trainerQualification = trainerQualification;
	}

	public String getTrainerSpecialist() {
		return trainerSpecialist;
	}

	public void setTrainerSpecialist(String trainerSpecialist) {
		this.trainerSpecialist = trainerSpecialist;
	}

	public int getTrainerExperience() {
		return trainerExperience;
	}

	public void setTrainerExperience(int trainerExperience) {
		this.trainerExperience = trainerExperience;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", trainerQualification="
				+ trainerQualification + ", trainerSpecialist=" + trainerSpecialist + ", trainerExperience="
				+ trainerExperience + ", emailId=" + emailId + ", contactNumber=" + contactNumber + "]";
	}
}
