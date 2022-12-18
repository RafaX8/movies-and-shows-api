package com.rafaelmardom.movies_and_shows_api.data.local.db

import com.rafaelmardom.movies_and_shows_api.domain.Movie

fun MovieEntity.toDomain() = Movie(
    this.id,
    this.title,
    this.plot,
    this.genre,
    this.rating,
    this.year,
    this.poster
)
fun Movie.toEntity() = MovieEntity(
    this.id,
    this.title,
    this.plot,
    this.genre,
    this.rating,
    this.year,
    this.poster
)