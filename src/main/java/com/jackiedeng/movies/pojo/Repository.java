package com.jackiedeng.movies.pojo;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/18 22:01
 * @Description
 */
public class Repository {

    private Integer id;

    private Integer schedule_id;
    /**
    * 座位余量*/
    private Integer reserve;
    /**
     *当前座位排列，以二维数组进行存储
     * */
    private String seats;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(Integer schedule_id) {
        this.schedule_id = schedule_id;
    }

    public Integer getReserve() {
        return reserve;
    }

    public void setReserve(Integer reserve) {
        this.reserve = reserve;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "id=" + id +
                ", schedule_id=" + schedule_id +
                ", reserve=" + reserve +
                ", seats='" + seats + '\'' +
                '}';
    }
}
