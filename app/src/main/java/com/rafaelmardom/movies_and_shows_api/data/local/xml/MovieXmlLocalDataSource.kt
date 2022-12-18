package com.rafaelmardom.movies_and_shows_api.data.local.xml

import android.content.SharedPreferences
import com.google.gson.Gson
import com.rafaelmardom.movies_and_shows_api.data.local.MovieLocalDataSource
import com.rafaelmardom.movies_and_shows_api.domain.Movie

class MovieXmlLocalDataSource (
    private val sharedPreferences: SharedPreferences,
    // private val serializer: KSerializer // yet to implement
) : MovieLocalDataSource{

    private val editor = sharedPreferences.edit()
    private val gson = Gson()

    override fun getAll(): List<Movie> {
        val movies = mutableListOf<Movie>()
        sharedPreferences.all.forEach {
            editor.apply {
                movies.add(gson.fromJson(it.value as String, Movie::class.java))
            }.apply()
        }
        return movies

    }

    override fun getById(movieId: String): Movie? =
        sharedPreferences.getString(movieId, null).let{
            gson.fromJson(it, Movie::class.java)
        }

    override fun saveAll(moviesList: List<Movie>) {
        moviesList.forEach {
            editor.putString(it.id, gson.toJson(it, Movie::class.java))
        }
        editor.apply()
    }
}