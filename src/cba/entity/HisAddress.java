package cba.entity;

import cba.dao.HisAddressDao;

public class HisAddress {
    private int orderId;//订单ID
    private String orderStart;//订单起始地址
    private String orderEnd;//订单终点地址
    private String addresser;//饲主
    private String contact;//饲主联系方式
    private String addressee;//收件人
    private String contact1;//收件人联系方式



    public HisAddress() {
    }

    public HisAddress(int orderId, String orderStart, String orderEnd, String addresser, String contact, String addressee,String contact1) {
        this.orderId = orderId;
        this.orderStart = orderStart;
        this.orderEnd = orderEnd;
        this.addresser = addresser;
        this.contact = contact;
        this.addressee = addressee;
        this.contact1 = contact1;

    }


    @Override
    public String toString() {
        return "HisAddress{" +
                "orderId=" + orderId +
                ", orderStart='" + orderStart + '\'' +
                ", orderEnd='" + orderEnd + '\'' +
                ", addresser='" + addresser + '\'' +
                ", contact='" + contact + '\'' +
                ", addressee='" + addressee + '\'' +
                ", contact1='" + contact1 + '\'' +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }
}
