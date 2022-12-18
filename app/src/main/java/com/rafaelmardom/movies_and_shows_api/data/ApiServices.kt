package com.rafaelmardom.movies_and_shows_api.data

import com.rafaelmardom.movies_and_shows_api.data.remote.api.MovieApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {

    @GET("movies")
    fun getMoviesFeed(): Call<List<MovieApiModel>>
    @GET("movies/{movieId}")
    fun getMovieById(@Path("movieId") movieId:String): Call<MovieApiModel>

}