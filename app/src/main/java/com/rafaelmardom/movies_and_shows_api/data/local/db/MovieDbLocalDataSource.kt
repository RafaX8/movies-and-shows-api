package com.rafaelmardom.movies_and_shows_api.data.local.db

import com.rafaelmardom.movies_and_shows_api.data.local.MovieLocalDataSource
import com.rafaelmardom.movies_and_shows_api.domain.Movie

class MovieDbLocalDataSource (private val dao: MovieDao) : MovieLocalDataSource {

    override fun saveAll(moviesList: List<Movie>) {
        moviesList.forEach {
            dao.save(it.toEntity())
        }
    }

    override fun getAll(): List<Movie> = dao.getAll().map { it.toDomain() }

    override fun getById(movieId: String): Movie? = dao.getById(movieId)?.toDomain()
}