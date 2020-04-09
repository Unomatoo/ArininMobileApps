package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.photogallery.api.FetchItemTask;
import com.example.photogallery.api.FlickrFetch;
import com.example.photogallery.db.PhotosDB;
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
    List<Photo> favoritesPhotoItems;
    private PhotosDB db;
    Boolean stateIsFavorites = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);
        retrofit = FetchItemTask.getRetrofit();
        flickrFetch = retrofit.create(FlickrFetch.class);
        db = PhotosDB.getDatabase(getApplicationContext());
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                db.clearAllTables();
            }
        });
        photoItems = new ArrayList<>();
        favoritesPhotoItems = new ArrayList<>();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public static FlickrFetch getApi() {
        return flickrFetch;
    }

    public void onFavoritesClick(MenuItem item) {
        if (stateIsFavorites) {
            rv.setAdapter(new PhotoAdapter(this, photoItems));
            rv.getAdapter().notifyDataSetChanged();
            Toast.makeText(this, R.string.favorites_closed_text, Toast.LENGTH_SHORT).show();
            stateIsFavorites = false;
        } else {
            rv.setAdapter(new PhotoAdapter(this, favoritesPhotoItems));
            favoritesPhotoItems.clear();
            favoritesPhotoItems.addAll(db.photoDao().LoadAll());
            rv.getAdapter().notifyDataSetChanged();
            Toast.makeText(this, R.string.favorites_loaded_text, Toast.LENGTH_SHORT).show();
            stateIsFavorites = true;
        }
    }
}
