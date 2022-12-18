package com.rafaelmardom.movies_and_shows_api.data

import com.rafaelmardom.movies_and_shows_api.data.local.MovieLocalDataSource
import com.rafaelmardom.movies_and_shows_api.data.remote.MovieRemoteDataSource
import com.rafaelmardom.movies_and_shows_api.domain.Movie
import com.rafaelmardom.movies_and_shows_api.domain.MovieRepository

class MovieDataRepository(
    private val localSource: MovieLocalDataSource,
    private val remoteSource: MovieRemoteDataSource
) : MovieRepository{

    override suspend fun getAll(): List<Movie> {

        return if (localSource.getAll().isNotEmpty()){
            localSource.getAll()
        }else{
            var remoteList = remoteSource.getAll()
            localSource.saveAll(remoteList)
            return remoteList
        }
    }

    override suspend fun getById(movieId: String): Movie? {
        return localSource.getById(movieId) ?: remoteSource.getById(movieId)
    }
}