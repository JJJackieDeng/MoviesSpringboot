package com.jackiedeng.movies.pojo;

import java.sql.Timestamp;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/4 22:44
 * @Description
 */
public class Score {
    private Integer id;
    private Integer movie_id;
    private Integer user_id;
    private String score;
    private String comments;
    private Timestamp createTime;

    /**
     * 联查Movie表*/
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", movie_id=" + movie_id +
                ", user_id=" + user_id +
                ", score='" + score + '\'' +
                ", comments='" + comments + '\'' +
                ", createTime=" + createTime +
                ", movie=" + movie +
                '}';
    }
}
