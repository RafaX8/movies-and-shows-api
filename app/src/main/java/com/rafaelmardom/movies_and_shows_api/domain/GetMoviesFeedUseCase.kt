package com.rafaelmardom.movies_and_shows_api.domain

class GetMoviesFeedUseCase (private val movieRepository: MovieRepository) {

    fun execute () : List<MovieFeed> {
        val movies = movieRepository.getMovies()

        return movies.map {
            MovieFeed(
                it.id,
                it.title,
                it.genre,
                it.rating,
                it.poster
            )
        }
    }

}

data class MovieFeed (
    val id: String,
    val title: String,
    // val plot: String, // We don't use that here
    val genre: String,
    val rating: Double,
    // val year: String,
    val poster: String
)