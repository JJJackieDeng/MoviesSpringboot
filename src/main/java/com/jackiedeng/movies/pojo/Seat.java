package com.jackiedeng.movies.pojo;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/20 17:20
 * @Description
 */

public class Seat {

    private Integer id;
    private Integer schedule_id;
    private Integer row;
    private Integer column;
    private String seatid;

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

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getSeatid() {
        return seatid;
    }

    public void setSeatid(String seatid) {
        this.seatid = seatid;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", schedule_id=" + schedule_id +
                ", row=" + row +
                ", column=" + column +
                ", seatid='" + seatid + '\'' +
                '}';
    }
}
