package cba.entity;

public class Order {
private int orderId;
private String orderStart;
private String orderEnd;
private int petId;
private String addresser;//�ջ���
private String addressee;
private String petShopContact;
private String remarks;
private String orderAmount;
private String clientContact;
private String runnerContact;
private String runnerName;
private String orderTime;
private String kilometers;
private String orderState;
private int userId;
private String addresseeContact;
private String iteminfo;

	public String getIteminfo() {
		return iteminfo;
	}

	public void setIteminfo(String iteminfo) {
		this.iteminfo = iteminfo;
	}

	public String getOrderStart() {
	return orderStart;
}
public void setOrderStart(String orderStart) {
	this.orderStart = orderStart;
}
public String getOrderEnd() {
	return orderEnd;
}
public void setOrderEnd(String orderEnd) {
	this.orderEnd = orderEnd;
}

public String getAddresser() {
	return addresser;
}
public void setAddresser(String addresser) {
	this.addresser = addresser;
}
public String getAddressee() {
	return addressee;
}
public void setAddressee(String addressee) {
	this.addressee = addressee;
}
public String getPetShopContact() {
	return petShopContact;
}
public void setPetShopContact(String petShopContact) {
	this.petShopContact = petShopContact;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
public String getOrderAmount() {
	return orderAmount;
}
public void setOrderAmount(String orderAmount) {
	this.orderAmount = orderAmount;
}
public String getClientContact() {
	return clientContact;
}
public void setClientContact(String clientContact) {
	this.clientContact = clientContact;
}
public String getRunnerContact() {
	return runnerContact;
}
public void setRunnerContact(String runnerContact) {
	this.runnerContact = runnerContact;
}
public String getRunnerName() {
	return runnerName;
}
public void setRunnerName(String runnerName) {
	this.runnerName = runnerName;
}
public String getOrderTime() {
	return orderTime;
}
public void setOrderTime(String orderTime) {
	this.orderTime = orderTime;
}
public String getKilometers() {
	return kilometers;
}
public void setKilometers(String kilometers) {
	this.kilometers = kilometers;
}
public String getOrderState() {
	return orderState;
}
public void setOrderState(String orderState) {
	this.orderState = orderState;
}

public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public int getPetId() {
	return petId;
}
public void setPetId(int petId) {
	this.petId = petId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getAddresseeContact() {
	return addresseeContact;
}
public void setAddresseeContact(String addresseeContact) {
	this.addresseeContact = addresseeContact;
}




}
