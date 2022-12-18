package com.rafaelmardom.movies_and_shows_api.data.remote.api

import com.rafaelmardom.movies_and_shows_api.domain.Movie

fun MovieApiModel.toDomain(): Movie = Movie(
    this.id,
    this.title,
    this.plot,
    this.genre,
    this.rating,
    this.year,
    this.poster
)