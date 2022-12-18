package com.rafaelmardom.movies_and_shows_api.presentation

import android.content.Context
import androidx.room.Room
import com.rafaelmardom.app.data.db.AppDatabase
import com.rafaelmardom.movies_and_shows_api.data.ApiClient
import com.rafaelmardom.movies_and_shows_api.data.MovieDataRepository
import com.rafaelmardom.movies_and_shows_api.data.local.db.MovieDbLocalDataSource
import com.rafaelmardom.movies_and_shows_api.data.remote.api.MovieApiRemoteDataSource
import com.rafaelmardom.movies_and_shows_api.domain.GetMovieDetailUseCase
import com.rafaelmardom.movies_and_shows_api.domain.GetMoviesFeedUseCase
import com.rafaelmardom.movies_and_shows_api.domain.MovieRepository

class MovieFactory {
    // --------------------------------FEED-----------------------------------
    fun getMoviesViewModel(applicationContext: Context) : MovieFeedViewModel {
        return MovieFeedViewModel(getMovieFeedUseCase(applicationContext))
    }

    private fun getMovieFeedUseCase(context: Context): GetMoviesFeedUseCase {
        return GetMoviesFeedUseCase(
            getMovieRepository(context)
        )
    }
    // -------------------------------------------------------------------
    // --------------------------------DETAIL-----------------------------------
    fun getMoviesDetailViewModel(applicationContext: Context) : MovieDetailViewModel {
        return MovieDetailViewModel(getMovieDetailUseCase(applicationContext))
    }
    private fun getMovieDetailUseCase(context: Context): GetMovieDetailUseCase {
        return GetMovieDetailUseCase(getMovieRepository(context))
    }
    // -------------------------------------------------------------------
    private fun getMovieRepository(context: Context): MovieRepository {
        return MovieDataRepository(
            MovieDbLocalDataSource(
                DataBaseSingleton.getInstance(
                    context
                ).MovieDao()
            ),
            MovieApiRemoteDataSource(
                ApiClient()
            )
        )
    }

    // -------------------------------------------------------------------
    object DataBaseSingleton {
        private var db: AppDatabase? = null

        fun getInstance (context: Context): AppDatabase{
            if (db == null) {
                db = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "dbMovies"
                ).build()
            }
            return db!!
        }
    }
}