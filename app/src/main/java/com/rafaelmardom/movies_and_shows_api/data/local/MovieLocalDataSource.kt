package com.rafaelmardom.movies_and_shows_api.data.local

import com.rafaelmardom.movies_and_shows_api.domain.Movie

interface MovieLocalDataSource {
    fun getAll(): List<Movie>
    fun getById(movieId: String): Movie?
    fun saveAll(moviesList: List<Movie>)
}