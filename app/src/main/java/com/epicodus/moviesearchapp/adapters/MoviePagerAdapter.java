package com.epicodus.moviesearchapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.moviesearchapp.models.Movie;
import com.epicodus.moviesearchapp.ui.MovieDetailFragment;

import java.util.ArrayList;

public class MoviePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Movie> mMovies;

    public MoviePagerAdapter(FragmentManager fm, ArrayList<Movie> movies) {
        super(fm);
        mMovies = movies;
    }

    @Override
    public Fragment getItem(int position) {
        return MovieDetailFragment.newInstance(mMovies.get(position));
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMovies.get(position).getTitle();
    }
}
