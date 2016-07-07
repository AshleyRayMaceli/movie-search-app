package com.epicodus.moviesearchapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.epicodus.moviesearchapp.R;
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

    @Bind(R.id.movieResultsListView) ListView mMovieResultsListView;

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
                        String[] movieTitles = new String[mMovies.size()];
                        for (int i = 0; i < movieTitles.length; i++) {
                            movieTitles[i] = mMovies.get(i).getTitle();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(TitleResultsActivity.this, android.R.layout.simple_list_item_1, movieTitles);
                        mMovieResultsListView.setAdapter(adapter);

                    }
                });
            }

        });
    }
}
