package com.rafaelmardom.movies_and_shows_api.data.remote.db

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.rafaelmardom.movies_and_shows_api.data.remote.MovieRemoteDataSource
import com.rafaelmardom.movies_and_shows_api.domain.Movie
import kotlinx.coroutines.tasks.await

class MovieDbRemoteDataSource : MovieRemoteDataSource{
    override suspend fun getAll(): List<Movie> {
        val movie = mutableListOf<Movie>()
        val dbRemote = Firebase.database.reference

        val snapshots = dbRemote.get().await()

        snapshots.children.forEach{
            it.getValue(MovieDbRemoteModel::class.java)?.let{
                movie.add(it.toDomain())
            }
        }

        return movie
    }

    override suspend fun getById(movieId: String): Movie? {
        val dbRemote = Firebase.database.reference.child(movieId)

        val snapshots = dbRemote.get().await()

        return snapshots.getValue(MovieDbRemoteModel::class.java)?.toDomain()
    }
}