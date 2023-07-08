package com.example.newsz;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    String Base_URL="https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<mainNews> getnews(
            @Query("country") String country,
            @Query("PageSize") int pagesize,
            @Query("apiKey") String apikey
    );
    @GET("top-headlines")
    Call<mainNews> getCategorynews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("PageSize") int pagesize,
            @Query("apiKey") String apikey
    );
}
