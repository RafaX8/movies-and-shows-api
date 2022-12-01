package com.rafaelmardom.movies_and_shows_api.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {
    @Query("SELECT * FROM $TABLE_MOVIES")
    fun getAll(): List<MovieEntity>

    @Query("SELECT * FROM $TABLE_MOVIES WHERE $TABLE_MOVIES_PK = :movieId")
    fun getById(movieId: String): MovieEntity?

    @Insert
    fun save(movieEntity: MovieEntity)
}