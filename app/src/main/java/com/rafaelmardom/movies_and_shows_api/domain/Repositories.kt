package com.rafaelmardom.movies_and_shows_api.domain

interface MovieRepository {
    fun getMovies(): List<Movie>
    fun getMovieById(movieId: String): Movie?
}