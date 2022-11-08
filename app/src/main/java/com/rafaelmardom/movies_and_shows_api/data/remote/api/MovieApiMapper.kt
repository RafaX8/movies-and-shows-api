package com.rafaelmardom.movies_and_shows_api.data.remote.api

import com.rafaelmardom.movies_and_shows_api.domain.Movie

// I personally don't like extension functions but meh, see I know how to do 'em.
fun MovieApiModel.toDomain(): Movie = Movie(
    this.id,
    this.title,
    this.plot,
    this.genre,
    this.rating,
    this.year,
    this.poster
)