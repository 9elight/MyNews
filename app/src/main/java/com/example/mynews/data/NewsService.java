package com.example.mynews.data;


import com.example.mynews.data.entity.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.mynews.data.ApiEndPionts.EVERYTHING;
import static com.example.mynews.data.ApiEndPionts.TOP_HEADLINES;

public interface NewsService {
    @GET(TOP_HEADLINES)
    Call<Example> getNews(@Query("country") String country,
                          @Query("apiKey") String apiKey);

    @GET(EVERYTHING)
    Call<Example> getNewsQword(@Query("q") String qWord,
                          @Query("language") String country,
                          @Query("apiKey") String apiKey);
}
