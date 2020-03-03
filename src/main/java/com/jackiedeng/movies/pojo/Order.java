package com.jackiedeng.movies.pojo;

import javax.rmi.CORBA.Tie;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/11 23:47
 * @Description
 */
public class Order {
    private Integer id;
    private String orderUser;
    private String orderId;
    private String status;
    private String address;
    private Time runTime;
    private Time endTime;
    private Timestamp createTime;
    private Timestamp modifiedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Time getRunTime() {
        return runTime;
    }

    public void setRunTime(Time runTime) {
        this.runTime = runTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderUser='" + orderUser + '\'' +
                ", orderId='" + orderId + '\'' +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", runTime=" + runTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
