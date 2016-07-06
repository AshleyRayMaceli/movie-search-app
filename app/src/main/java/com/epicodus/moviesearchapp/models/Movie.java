package com.epicodus.moviesearchapp.models;

import java.util.ArrayList;

public class Movie {
    String mTitle;
    double mRating;
    String mReleaseDate;
    ArrayList<String> mGenres = new ArrayList<>();
    String mOverview;
    String mSite;
    int mRunTime;

    public Movie(String title, double rating, String releaseDate, ArrayList<String> genres, String overview, String site, int runTime) {
        this.mTitle = title;
        this.mRating = rating;
        this.mReleaseDate = releaseDate;
        this.mGenres = genres;
        this.mOverview = overview;
        this.mSite = site;
        this.mRunTime = runTime;
    }

    public String getTitle() {
        return mTitle;
    }

    public double getRating() {
        return mRating;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public ArrayList<String> getGenres() {
        return mGenres;
    }

    public String getOverview() {
        return mOverview;
    }

    public String getSite() {
        return mSite;
    }

    public int getRunTime() {
        return mRunTime;
    }



}


