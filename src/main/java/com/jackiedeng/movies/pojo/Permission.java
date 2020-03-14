package com.jackiedeng.movies.pojo;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/14 17:17
 * @Description 权限实体
 */
public class Permission {

    private Integer permission_id;

    private String name;
    /**
     *权限标识
     **/
    private String perms;

    public Integer getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permission_id=" + permission_id +
                ", name='" + name + '\'' +
                ", perms='" + perms + '\'' +
                '}';
    }
}
