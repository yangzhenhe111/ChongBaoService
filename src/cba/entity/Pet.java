package cba.entity;

public class Pet {
	private int  petId;
	private String  picturePath;
	private String petName;
	private String petType;
	private int petAge;
	private String petAutograph;
	private String petWeight;
	private int userId;
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetAutograph() {
		return petAutograph;
	}
	public void setPetAutograph(String petAutograph) {
		this.petAutograph = petAutograph;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	public int getPetAge() {
		return petAge;
	}
	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}
	public String getPetWeight() {
		return petWeight;
	}
	public void setPetWeight(String petWeight) {
		this.petWeight = petWeight;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
