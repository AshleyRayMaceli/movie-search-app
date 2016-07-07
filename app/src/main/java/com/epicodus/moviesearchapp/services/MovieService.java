package com.epicodus.moviesearchapp.services;

import com.epicodus.moviesearchapp.Constants;
import com.epicodus.moviesearchapp.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;

public class MovieService {

    public static void findMoviesByTitle(String title, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        String url = Constants.MOVIE_BASE_URL + Constants.MOVIE_CONSUMER_KEY + "&query=" + title;

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Movie> processResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject movieDatabaseJSON = new JSONObject(jsonData);
                JSONArray resultsJSON = movieDatabaseJSON.getJSONArray("results");
                for (int i = 0; i < resultsJSON.length(); i++) {
                    JSONObject movieJSON = resultsJSON.getJSONObject(i);
                    String title = movieJSON.getString("title");
                    double rating = movieJSON.getDouble("vote_average");
                    String releaseDate = movieJSON.getString("release_date");
                    String overview = movieJSON.getString("overview");
                    String image = movieJSON.getString("poster_path");

                    Movie movie = new Movie(title, rating, releaseDate, overview, image);
                    movies.add(movie);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
