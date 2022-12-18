package com.rafaelmardom.movies_and_shows_api.domain

class GetMoviesFeedUseCase (private val movieRepository: MovieRepository) {

    suspend fun execute () : List<MovieFeed> {
        return movieRepository.getAll().map {
            MovieFeed(
                it.id,
                it.title,
                it.genre,
                it.rating,
                it.poster
            )
        }
    }

    data class MovieFeed (
        val id: String,
        val title: String,
        val genre: String,
        val rating: Double,
        val poster: String
    )
}