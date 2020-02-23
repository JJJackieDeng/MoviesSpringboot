package com.jackiedeng.movies.pojo;

import java.sql.Timestamp;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2019/12/8 23:29
 * @Description
 */
public class User{
    private int id;
    private int age;
    private String sex;
    private String userName;
    private String password;
    private String phoneNumber;
    private Timestamp createTime;
    private Timestamp modifiedTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
