package com.rafaelmardom.movies_and_shows_api.domain

interface MovieRepository {
    suspend fun getAll(): List<Movie>
    suspend fun getById(movieId: String): Movie?
}