package com.rafaelmardom.movies_and_shows_api.presentation

import android.content.Context
import android.content.SharedPreferences
import com.rafaelmardom.movies_and_shows_api.data.ApiClient
import com.rafaelmardom.movies_and_shows_api.data.MovieDataRepository
import com.rafaelmardom.movies_and_shows_api.data.local.xml.MovieXmlLocalDataSource
import com.rafaelmardom.movies_and_shows_api.data.remote.api.MovieApiRemoteDataSource
import com.rafaelmardom.movies_and_shows_api.domain.GetMovieDetailUseCase
import com.rafaelmardom.movies_and_shows_api.domain.GetMoviesFeedUseCase
import com.rafaelmardom.movies_and_shows_api.domain.MovieRepository

class MovieFactory {
    /*
    private fun getApiClient() = ApiClient()

    private fun getSharedPreferences(
        context: Context,
        nameSharedPreferences: String
    ): SharedPreferences {
        return context.getSharedPreferences(nameSharedPreferences, Context.MODE_PRIVATE)
    }
    */

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
            // Cambiar LocalSource a ROOM DB cuando esté correctamente mergeado
            MovieXmlLocalDataSource(
                //getSharedPreferences(context, "moviesSharedPreferences")
                context.getSharedPreferences("movies", Context.MODE_PRIVATE)
            ),
            //MovieApiRemoteDataSource(getApiClient())
            MovieApiRemoteDataSource(
                ApiClient()
            )
        )
    }
}