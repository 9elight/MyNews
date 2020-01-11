package com.example.mynews.data;


import com.example.mynews.data.entity.Article;
import com.example.mynews.data.entity.Articles;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.mynews.data.ApiEndPionts.TOP_HEADLINES;

public interface NewsService {
    @GET (TOP_HEADLINES)
    Call<JsonObject> getNews (@Query("country") String country,
                              @Query("apiKey") String apiKey);

    @GET(TOP_HEADLINES)
    Call<Articles> getNews2 (@Query("country") String country,
                             @Query("apiKey") String apiKey);
}
