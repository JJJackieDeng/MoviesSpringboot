package com.jackiedeng.movies.pojo;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2019/12/8 23:29
 * @Description
 */
public class User{
    private int id;
    private String username;
    private String password;
    private String phonenumber;
    private Timestamp createtime;
    private Timestamp modifiedtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Timestamp modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", createtime=" + createtime +
                ", modifiedtime=" + modifiedtime +
                '}';
    }
}
