package com.rafaelmardom.movies_and_shows_api.domain

interface MovieRepository {
    fun getAll(): List<Movie>
    fun getById(movieId: String): Movie?
}