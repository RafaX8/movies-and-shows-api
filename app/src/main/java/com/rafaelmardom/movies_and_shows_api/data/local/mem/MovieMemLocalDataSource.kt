package com.rafaelmardom.movies_and_shows_api.data.local.mem

import com.rafaelmardom.app.data.mem.MemDataStore
import com.rafaelmardom.movies_and_shows_api.data.local.MovieLocalDataSource
import com.rafaelmardom.movies_and_shows_api.domain.Movie

class MovieMemLocalDataSource (
    private val dataStore: MemDataStore<Movie>
) : MovieLocalDataSource {

    override fun getAll(): List<Movie> {
        return dataStore.getAll()
    }

    override fun getById(movieId: String): Movie? {
        return dataStore.get(movieId)
    }

    override fun saveAll(moviesList: List<Movie>) {
        moviesList.forEach {
            dataStore.put(it.id, it)
        }
    }


}