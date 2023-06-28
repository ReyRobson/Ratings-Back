package com.Ratings.demo;

import java.util.List;

public class ResponseResultList {
    Boolean adult;
    String backdrop_path;
    List<Integer> genre_ids;
    int id;
    String original_language;
    String original_title;
    String overview;
    float popularity;
    String poster_path;
    String release_date;
    String title;
    Boolean video;
    float vote_average;
    float vote_count;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_language() {
        return original_language;
    }
    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }
    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }

    public float getPopularity() {
        return popularity;
    }
    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }
    
    public String getPoster_path() {
        return poster_path;
    }
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Boolean getVideo() {
        return video;
    }
    public void setVideo(Boolean video) {
        this.video = video;
    }

    public float getVote_average() {
        return vote_average;
    }
    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public float getVote_count() {
        return vote_count;
    }
    public void setVote_count(float vote_count) {
        this.vote_count = vote_count;
    }
}
