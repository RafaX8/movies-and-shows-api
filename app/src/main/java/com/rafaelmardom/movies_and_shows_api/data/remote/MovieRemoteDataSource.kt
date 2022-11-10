package com.rafaelmardom.movies_and_shows_api.data.remote

import com.rafaelmardom.movies_and_shows_api.domain.Movie

interface MovieRemoteDataSource {
    suspend fun getAll(): List<Movie>
    suspend fun getById(movieId: String): Movie?
}