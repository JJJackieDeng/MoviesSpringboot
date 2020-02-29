package com.jackiedeng.movies.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 00:27
 * @Description
 */
public class Movie{
    private int id;
    private String movie_id;
    private String movieName;
    private Timestamp createTime;
    private Timestamp modifiedTime;
    /**
     * 联查MovieInfo表*/
    private MovieInfo movieInfo;

    public MovieInfo getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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
        return "MovieController{" +
                "id=" + id +
                ", movie_id='" + movie_id + '\'' +
                ", movieName='" + movieName + '\'' +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
