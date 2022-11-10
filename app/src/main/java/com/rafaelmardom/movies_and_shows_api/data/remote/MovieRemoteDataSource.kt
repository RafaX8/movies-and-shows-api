package com.rafaelmardom.movies_and_shows_api.data.remote

import com.rafaelmardom.movies_and_shows_api.domain.Movie

interface MovieRemoteDataSource {
    fun getAll(): List<Movie>
    fun getById(movieId: String): Movie?
}