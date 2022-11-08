package com.rafaelmardom.movies_and_shows_api.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rafaelmardom.movies_and_shows_api.R
import com.rafaelmardom.movies_and_shows_api.data.ApiClient
import kotlin.concurrent.thread

class MoviesFeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_feed)

        // TEST
        thread {
            val movies = ApiClient().getMovies()
            val movie = ApiClient().getMovieById("avenger-endgame")
            Log.d("@dev", movies.subList(1,3).toString())
            Log.d("@dev", movie.toString())
        }
    }
}