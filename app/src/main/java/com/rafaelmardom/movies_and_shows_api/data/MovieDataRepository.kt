package com.rafaelmardom.movies_and_shows_api.data

import com.rafaelmardom.movies_and_shows_api.data.remote.MovieRemoteDataSource
import com.rafaelmardom.movies_and_shows_api.domain.Movie
import com.rafaelmardom.movies_and_shows_api.domain.MovieRepository

class MovieDataRepository(
    // private val localSource: MovieLocalDataSource,
    private val remoteSource: MovieRemoteDataSource
) : MovieRepository{

    override fun getAll(): List<Movie> {
        // ONLY REMOTE YET --> Change when Local Data is finished
        /*
        return if (localSource.getMovies().isNotEmpty()){
            localSource.getMovies()
        }else{
            remoteSource.getMovies()
        }
        */
        return remoteSource.getAll()
    }

    override fun getById(movieId: String): Movie? {
        // ONLY REMOTE YET --> Change when Local Data is finished
        // return localSource.getMovieById(movieId) ?: remoteSource.getMovieById(movieId)
        return remoteSource.getById(movieId)
    }
}