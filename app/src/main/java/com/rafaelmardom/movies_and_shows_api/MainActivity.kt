package com.rafaelmardom.movies_and_shows_api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rafaelmardom.movies_and_shows_api.databinding.ActivityMainBinding
import com.rafaelmardom.movies_and_shows_api.presentation.MovieDetailFragment
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBinding()
        //<!-- TEST -> BORRAR DESPUES -->
        thread {
            startActivity(Intent(this, MovieDetailFragment::class.java))
        }
        //<!-- TEST -->
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }
}