package com.rafaelmardom.movies_and_shows_api.data.remote

import com.rafaelmardom.movies_and_shows_api.domain.Movie

interface MovieRemoteDataSource {
    fun getMovies(): List<Movie>
    fun getMovieById(movieId: String): Movie?
}