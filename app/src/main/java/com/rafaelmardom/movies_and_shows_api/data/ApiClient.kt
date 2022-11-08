package com.rafaelmardom.movies_and_shows_api.data

import com.rafaelmardom.movies_and_shows_api.data.remote.api.MovieApiModel
// note: Sometimes Android Studio doesn't import correctly --> copyPaste manually
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
RETROFIT here
*/
class ApiClient {
    // note: Gson Serialization: try to implement KSerialization next time
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