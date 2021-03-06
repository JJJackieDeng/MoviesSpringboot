package com.jackiedeng.movies.pojo;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/11 16:33
 * @Description 用户与角色实体
 */
public class UserRole {
    private Integer role_id;
    private String role_name;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
