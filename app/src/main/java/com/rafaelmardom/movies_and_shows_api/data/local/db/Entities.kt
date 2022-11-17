package com.rafaelmardom.movies_and_shows_api.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_MOVIES = "movies"
const val TABLE_MOVIES_PK = "id"

@Entity(tableName = TABLE_MOVIES)
data class MovieEntity (
    @PrimaryKey @ColumnInfo(name = TABLE_MOVIES_PK) val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "plot") val plot: String,
    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "rating") val rating: Double,
    @ColumnInfo(name = "year") val year: String,
    @ColumnInfo(name = "poster") val poster: String
)
