package com.rafaelmardom.movies_and_shows_api.data.remote.db

data class MovieDbRemoteModel (
    val id: String,
    val title: String,
    val plot: String,
    val genre: String,
    val rating: Double,
    val year: String,
    val poster: String
)