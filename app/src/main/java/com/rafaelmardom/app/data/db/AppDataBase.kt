package com.rafaelmardom.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rafaelmardom.movies_and_shows_api.data.local.db.MovieDao
import com.rafaelmardom.movies_and_shows_api.data.local.db.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun MovieDao(): MovieDao
}