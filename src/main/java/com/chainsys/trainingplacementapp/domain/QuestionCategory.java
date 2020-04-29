package com.chainsys.trainingplacementapp.domain;

public class QuestionCategory {
	
	private int categoryId;
	private String categoryName;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public String setCategoryName(String categoryName) {
		return this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "QuestionCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}
