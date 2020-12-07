package cba.entity;


public class User {
	private int userId;//�û�ID
	private String userName;//�û�����
	private String userSex;//�û��Ա�
	private String accountNumber;//�˺�
	private double accountAmount;//�˻����
	private String picturePath;//ͼƬ·��
	private String userPassword;//�û�����
	private String userPhone;//�û��ֻ���
	private String userBrithday;//�û�����
	private String userAutograph;//����ǩ��

	public User() {
	}

	public User(int userId, String userName, String userSex, String accountNumber, double accountAmount, String picturePath, String userPassword, String userPhone, String userBrithday, String userAutograph) {
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.accountNumber = accountNumber;
		this.accountAmount = accountAmount;
		this.picturePath = picturePath;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userBrithday = userBrithday;
		this.userAutograph = userAutograph;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", userSex='" + userSex + '\'' +
				", accountNumber='" + accountNumber + '\'' +
				", accountAmount=" + accountAmount +
				", picturePath='" + picturePath + '\'' +
				", userPassword='" + userPassword + '\'' +
				", userPhone='" + userPhone + '\'' +
				", userBrithday='" + userBrithday + '\'' +
				", userAutograph='" + userAutograph + '\'' +
				'}';
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public double getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(double accountAmount) {
		this.accountAmount = accountAmount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserBrithday() {
		return userBrithday;
	}

	public void setUserBrithday(String userBrithday) {
		this.userBrithday = userBrithday;
	}

	public String getUserAutograph() {
		return userAutograph;
	}

	public void setUserAutograph(String userAutograph) {
		this.userAutograph = userAutograph;
	}
}
