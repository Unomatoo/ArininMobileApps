package com.example.photogallery.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FetchItemTask {
    private static final String BASE_URL = "https://api.flickr.com/";
    public static final String API_KEY = "ac3b3c2b647f3fa1fd3c173c9ca3c523";
    public static final String API_SECRET = "d1f92671051e37e1";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            return retrofit;
        }
        return retrofit;
    }
}
