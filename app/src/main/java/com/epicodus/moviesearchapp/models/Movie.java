package com.epicodus.moviesearchapp.models;

import org.parceler.Parcel;

@Parcel
public class Movie {
    String mTitle;
    double mRating;
    String mReleaseDate;
    String mOverview;
    String mImage;

    public Movie() {}

    public Movie(String title, double rating, String releaseDate, String overview, String image) {
        this.mTitle = title;
        this.mRating = rating;
        this.mReleaseDate = releaseDate;
        this.mOverview = overview;
        this.mImage = "http://image.tmdb.org/t/p/w500" + image;
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

    public String getOverview() {
        return mOverview;
    }

    public String getImage() { return mImage; }
}


