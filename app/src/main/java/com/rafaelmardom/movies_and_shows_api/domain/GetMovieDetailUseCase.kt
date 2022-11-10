package com.rafaelmardom.movies_and_shows_api.domain

class GetMovieDetailUseCase (private val movieRepository: MovieRepository) {

    fun execute (movieId: String) : MovieDetail {
        val movie = movieRepository.getById(movieId)!!


        return MovieDetail(
            movie.id,
            movie.title,
            movie.plot,
            movie.genre,
            movie.rating,
            movie.year,
            movie.poster
            )
    }

    data class MovieDetail (
        val id: String,
        val title: String,
        val plot: String,
        val genre: String,
        val rating: Double,
        val year: String,
        val poster: String
    )
}