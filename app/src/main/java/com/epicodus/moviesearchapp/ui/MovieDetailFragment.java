package com.epicodus.moviesearchapp.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.moviesearchapp.R;
import com.epicodus.moviesearchapp.models.Movie;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetailFragment extends Fragment {

    @Bind(R.id.movieImageView) ImageView mImageLabel;
    @Bind(R.id.movieTitleTextView) TextView mTitleLabel;
    @Bind(R.id.releaseDateTextView) TextView mReleaseDateLabel;
    @Bind(R.id.ratingTextView) TextView mRatingLabel;
    @Bind(R.id.overviewTextView) TextView mOverviewLabel;

    private Movie mMovie;

    public static MovieDetailFragment newInstance(Movie movie) {
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("movie", Parcels.wrap(movie));
        movieDetailFragment.setArguments(args);
        return movieDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovie = Parcels.unwrap(getArguments().getParcelable("movie"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mMovie.getImage()).into(mImageLabel);

        mTitleLabel.setText(mMovie.getTitle());
        mReleaseDateLabel.setText(mMovie.getReleaseDate());
        mRatingLabel.setText(Double.toString(mMovie.getRating()) + " / 10");
        mOverviewLabel.setText(mMovie.getOverview());

        return view;
    }

}
