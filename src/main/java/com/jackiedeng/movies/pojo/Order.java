package com.jackiedeng.movies.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/11 23:47
 * @Description
 */
public class Order {
    private Integer id;
    private Integer movie_id;
    private Integer cinemaID;
    private String movieName;
    private String orderUser;
    private String orderId;
    private String status;
    private String address;
    private String runTime;
    private String endTime;
    private String seats;
    private String invalid;
    private String total;
    private String date;
    private Date createTime;
    private Timestamp modifiedTime;



    /**
     * 联查movieInfo表*/
    private MovieInfo movieInfo;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public MovieInfo getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public Integer getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(Integer cinemaID) {
        this.cinemaID = cinemaID;
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

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getInvalid() {
        return invalid;
    }

    public void setInvalid(String invalid) {
        this.invalid = invalid;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        return "Order{" +
                "id=" + id +
                ", movie_id=" + movie_id +
                ", cinemaID=" + cinemaID +
                ", movieName='" + movieName + '\'' +
                ", orderUser='" + orderUser + '\'' +
                ", orderId='" + orderId + '\'' +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", runTime='" + runTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", seats='" + seats + '\'' +
                ", invalid='" + invalid + '\'' +
                ", total='" + total + '\'' +
                ", date=" + date +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                ", movieInfo=" + movieInfo +
                '}';
    }
}
