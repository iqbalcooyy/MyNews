package com.iqbalproject.mynews.network

import com.iqbalproject.mynews.BuildConfig
import com.iqbalproject.mynews.model.Articles
import com.iqbalproject.mynews.model.Sources
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/sources")
    fun newsSource(@Query("category") category: String, @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY): Call<Sources>

    @GET("v1/articles")
    fun newsArticle(@Query("source") sourceId: String, @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY): Call<Articles>
}