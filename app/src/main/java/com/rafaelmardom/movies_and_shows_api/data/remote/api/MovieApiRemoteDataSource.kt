package com.rafaelmardom.movies_and_shows_api.data.remote.api

import com.rafaelmardom.movies_and_shows_api.data.ApiClient
import com.rafaelmardom.movies_and_shows_api.data.remote.MovieRemoteDataSource
import com.rafaelmardom.movies_and_shows_api.domain.Movie

class MovieApiRemoteDataSource (
    val apiClient: ApiClient
) : MovieRemoteDataSource {

    override suspend fun getAll(): List<Movie> {
        val movies = apiClient.getMovies()
        return movies.map{
            it.toDomain()
        }
    }

    override suspend fun getById(movieId: String): Movie? {
        return apiClient.getMovieById(movieId)?.toDomain()
    }
}