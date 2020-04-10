package com.jackiedeng.movies.pojo;

import java.sql.Timestamp;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 00:27
 * @Description
 */
public class Movie{
    private Integer id;
    private String movie_id;
    private String movieName;
    private String foreign;
    private String area;
    private Timestamp createTime;
    private Timestamp modifiedTime;
    /**
     * 联查MovieInfo表*/
    private MovieInfo movieInfo;
    /**
     * 联查score表*/
    private Score score;

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
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

    public String getForeign() {
        return foreign;
    }

    public void setForeign(String foreign) {
        this.foreign = foreign;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
        return "Movie{" +
                "id=" + id +
                ", movie_id='" + movie_id + '\'' +
                ", movieName='" + movieName + '\'' +
                ", foreign='" + foreign + '\'' +
                ", area='" + area + '\'' +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                ", movieInfo=" + movieInfo +
                ", score=" + score +
                '}';
    }

}
