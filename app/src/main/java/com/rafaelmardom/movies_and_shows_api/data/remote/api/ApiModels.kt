package com.rafaelmardom.movies_and_shows_api.data.remote.api

data class MovieApiModel (
    val id: String,
    val title: String,
    val plot: String,
    val genre: String,
    val rating: Double,
    val year: String,
    val poster: String
) {
    /*
    I personally don't like extension functions, so I would've written this here:

    fun toDomain(): Movie = Movie(
        this.id,
        this.title,
        this.plot,
        this.genre,
        this.rating,
        this.year,
        this.poster
    )

    Instead of creating a Mapper file.
    // SEE MovieApiMapper.kt
    */
}