package com.jackiedeng.movies.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/8 09:50
 * @Description
 */
public class Cinema {
    private Integer id;
    private String cinemaName;
    private String room;
    private String address;
    private String telephone;
    private String seats;
    private Date createTime;
    private Timestamp modifiedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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
        return "Cinema{" +
                "id=" + id +
                ", cinemaName='" + cinemaName + '\'' +
                ", room='" + room + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", seats='" + seats + '\'' +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
