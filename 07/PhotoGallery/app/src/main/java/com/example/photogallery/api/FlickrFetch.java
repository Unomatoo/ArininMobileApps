package com.example.photogallery.api;

import com.example.photogallery.model.PostModel;
import com.example.photogallery.model.ResponsePhotos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrFetch {
    @GET("services/rest/?method=flickr.photos.getRecent&api_key="+FetchItemTask.API_KEY+"&extras=url_s&format=json&nojsoncallback=1")
    Call<ResponsePhotos> getRecent();
    @GET("services/rest/?method=flickr.photos.search&api_key="+FetchItemTask.API_KEY+"&extras=url_s&format=json&nojsoncallback=1")
    Call<ResponsePhotos> getSearchPhotos(@Query("text") String keyWord);
}
