package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.photogallery.api.FetchItemTask;
import com.example.photogallery.api.FlickrFetch;
import com.example.photogallery.model.Photo;
import com.example.photogallery.model.PostModel;
import com.example.photogallery.model.ResponsePhotos;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PhotoGallery extends AppCompatActivity {

    private static FlickrFetch flickrFetch;
    RecyclerView rv;
    Retrofit retrofit;
    ResponsePhotos response;
    List<Photo> photoItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);
        retrofit = FetchItemTask.getRetrofit();
        flickrFetch = retrofit.create(FlickrFetch.class);

        photoItems = new ArrayList<>();

        rv = findViewById(R.id.recycler_view);
        rv.setLayoutManager(new GridLayoutManager(this, 3));
        rv.setAdapter(new PhotoAdapter(this, photoItems));

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                getApi().getRecent().enqueue(new Callback<ResponsePhotos>() {
                    @Override
                    public void onResponse(Call<ResponsePhotos> call, Response<ResponsePhotos> response) {
                        //Toast.makeText(PhotoGallery.this, "No error occurred during networking", Toast.LENGTH_SHORT).show();
                        photoItems.addAll(response.body().getPhotos().getPhoto());
                        rv.getAdapter().notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<ResponsePhotos> call, Throwable t) {
                        Toast.makeText(PhotoGallery.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public static FlickrFetch getApi() {
        return flickrFetch;
    }
}
