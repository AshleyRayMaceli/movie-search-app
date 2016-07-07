package com.epicodus.moviesearchapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.epicodus.moviesearchapp.R;
import com.epicodus.moviesearchapp.adapters.MovieListAdapter;
import com.epicodus.moviesearchapp.models.Movie;
import com.epicodus.moviesearchapp.services.MovieService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class TitleResultsActivity extends AppCompatActivity {
    public static final String TAG = TitleResultsActivity.class.getSimpleName();

    @Bind(R.id.movieResultsRecyclerView) RecyclerView mMovieResultsRecyclerView;
    private MovieListAdapter mAdapter;

    public ArrayList<Movie> mMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_results);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        getMoviesByTitle(title);
    }

    private void getMoviesByTitle(String title) {
        final MovieService movieService = new MovieService();
        movieService.findMoviesByTitle(title, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mMovies = movieService.processResults(response);

                TitleResultsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new MovieListAdapter(getApplicationContext(), mMovies);
                        mMovieResultsRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TitleResultsActivity.this);
                        mMovieResultsRecyclerView.setLayoutManager(layoutManager);
                        mMovieResultsRecyclerView.setHasFixedSize(true);
                    }
                });
            }

        });
    }
}
