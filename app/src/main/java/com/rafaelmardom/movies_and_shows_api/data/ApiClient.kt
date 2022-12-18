package com.rafaelmardom.movies_and_shows_api.data

import com.rafaelmardom.movies_and_shows_api.data.remote.api.MovieApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val baseUrl = "https://movies-and-shows-api.cyclic.app/"
    private val apiServices: ApiServices

    init{
        apiServices = retrofitBuild()
    }

    fun retrofitBuild() = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiServices::class.java)
    //

    fun getMovies(): List<MovieApiModel> {
        val movies = apiServices.getMoviesFeed()
        val response = movies.execute()
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        }else{
            emptyList()
        }
    }

    fun getMovieById(movieId: String): MovieApiModel? {
        val call = apiServices.getMovieById(movieId).execute()
        return call.body()
    }
}