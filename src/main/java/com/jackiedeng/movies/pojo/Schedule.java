package com.jackiedeng.movies.pojo;

import java.util.Date;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/17 23:17
 * @Description
 */
public class Schedule {
    private Integer id;
    private Integer cinema_id;
    private Integer movie_id;
    /**
     * 放映厅
     */
    private String room;
    /* *
     *场次
     */
    private String schedule;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(Integer cinema_id) {
        this.cinema_id = cinema_id;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", cinema_id=" + cinema_id +
                ", movie_id=" + movie_id +
                ", room='" + room + '\'' +
                ", schedule='" + schedule + '\'' +
                ", date=" + date +
                '}';
    }
}
