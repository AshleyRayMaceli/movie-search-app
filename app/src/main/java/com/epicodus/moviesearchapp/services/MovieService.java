package com.epicodus.moviesearchapp.services;

import com.epicodus.moviesearchapp.Constants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;

public class MovieService {

    public static void findMoviesByTitle(String title, Callback callback) {
//        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIE_BASE_URL).newBuilder();
//        urlBuilder.addQueryParameter(Constants.MOVIE_TITLE_QUERY_PARAMETER, title);
//        String url = urlBuilder.build().toString();
//
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        String url = Constants.MOVIE_BASE_URL + Constants.MOVIE_CONSUMER_KEY + "&query=" + title;

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
