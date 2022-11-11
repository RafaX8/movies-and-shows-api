package com.rafaelmardom.movies_and_shows_api.data

import android.util.Log
import com.rafaelmardom.movies_and_shows_api.data.local.MovieLocalDataSource
import com.rafaelmardom.movies_and_shows_api.data.remote.MovieRemoteDataSource
import com.rafaelmardom.movies_and_shows_api.domain.Movie
import com.rafaelmardom.movies_and_shows_api.domain.MovieRepository

class MovieDataRepository(
    private val localSource: MovieLocalDataSource,
    private val remoteSource: MovieRemoteDataSource
) : MovieRepository{

    override fun getAll(): List<Movie> {

        if (localSource.getAll().isNotEmpty()){
            Log.d("@dev", "Local")
            return localSource.getAll()
        }else{
            Log.d("@dev", "Remote")
            var remoteList = remoteSource.getAll()
            localSource.saveAll(remoteList)
            return remoteList
        }
    }

    override fun getById(movieId: String): Movie? {
        return localSource.getById(movieId) ?: remoteSource.getById(movieId)
    }
}