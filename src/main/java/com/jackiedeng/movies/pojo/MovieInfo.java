package com.jackiedeng.movies.pojo;

import java.sql.Timestamp;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/12 00:27
 * @Description
 */
public class MovieInfo {
    private Integer id;
    private Float score;
    private String introduce;
    private String movieLength;
    private String actors;
    private String director;
    private String release;
    private String poster;
    private Timestamp createTime;
    private Timestamp modifiedTime;

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

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(String movieLength) {
        this.movieLength = movieLength;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
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

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
                "id=" + id +
                ", score=" + score +
                ", introduce='" + introduce + '\'' +
                ", movieLength='" + movieLength + '\'' +
                ", actors='" + actors + '\'' +
                ", director='" + director + '\'' +
                ", release='" + release + '\'' +
                ", poster='" + poster + '\'' +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                ", movie=" + movie +
                '}';
    }
}
