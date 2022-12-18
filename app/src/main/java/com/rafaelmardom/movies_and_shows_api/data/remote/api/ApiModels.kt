package com.rafaelmardom.movies_and_shows_api.data.remote.api

data class MovieApiModel (
    val id: String,
    val title: String,
    val plot: String,
    val genre: String,
    val rating: Double,
    val year: String,
    val poster: String
)